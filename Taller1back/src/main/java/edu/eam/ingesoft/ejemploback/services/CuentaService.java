package edu.eam.ingesoft.ejemploback.services;

import edu.eam.ingesoft.ejemploback.model.Cliente;
import edu.eam.ingesoft.ejemploback.model.Cuenta;
import edu.eam.ingesoft.ejemploback.model.Transaccion;
import edu.eam.ingesoft.ejemploback.repositories.ClienteRepository;
import edu.eam.ingesoft.ejemploback.repositories.CuentaRepository;
import edu.eam.ingesoft.ejemploback.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private TransaccionService transaccionService;

    // Profe Me toco Improvisar con este contador
    // Ya que no encontre la manera de trabajar con un valor autoincrementable en DBeaver
    // Siempre me aparecío error
    int contador = 1;

    public  Cuenta crearCuenta (Cuenta cuenta) {
        Cliente cliente = clienteRepository.findById(cuenta.getCedulaCliente()).orElse(null);

        if (cliente == null) {
            throw new RuntimeException("No Existe el Cliente");
        }

        List<Cuenta> cuentasCliente = cuentaRepository.buscarCuentasCliente(cuenta.getCedulaCliente());

        if (cuentasCliente.size() == 3) {
            throw new RuntimeException("Supero el Limite de Cuentas");
        }

        cuentaRepository.save(cuenta);

        return cuenta;
    }

    public List<Cuenta> listarCuentasCliente(String cedula) {

        return cuentaRepository.buscarCuentasCliente(cedula);

    }

    public Cuenta consignacion (String cuentaCliente, double monto) {



        Cuenta cuentaBD = cuentaRepository.findById(cuentaCliente).orElse(null);
        if (cuentaBD == null) {

            throw new RuntimeException("No existe el Numero de Cuenta");

        }

        double nuevoMonto = cuentaBD.getAmount();


        if (monto > 0){
            nuevoMonto += monto;
            cuentaBD.setAmount(nuevoMonto);
            cuentaRepository.save(cuentaBD);

            Transaccion transaccion = new Transaccion(contador, cuentaBD.getId(), "consignación", monto, new Date());
            transaccionRepository.save(transaccion);

            contador += 1;
            return cuentaBD;

        } else {

            throw new RuntimeException("El Monto No es Permitido");

        }

    }

    public Cuenta retiro (String cuentaCliente, double monto) {

        Cuenta cuentaBD = cuentaRepository.findById(cuentaCliente).orElse(null);

        if (cuentaBD == null) {

            throw new RuntimeException("No existe el Numero de Cuenta");

        }


        double saldo = cuentaBD.getAmount();

        if (saldo >= monto){
            double saldoNuevo = saldo - monto;
            cuentaBD.setAmount(saldoNuevo);
            cuentaRepository.save(cuentaBD);

            Transaccion transaccion = new Transaccion(contador, cuentaBD.getId(), "retiro", monto, new Date());
            transaccionRepository.save(transaccion);
            contador += 1;
            return cuentaBD;

        } else {

            throw new RuntimeException("No hay Suficientes Fondos");

        }
    }

    public Cuenta transferencia(String cuentaClienteOrigen, String cuentaClienteDestino, double monto) {

        double nuevoMontoCuentaOrigen;
        double nuevoMontoCuentaDestino;


        Cuenta cuentaOrigen = cuentaRepository.findById(cuentaClienteOrigen).orElse(null);
        Cuenta cuentaDestino = cuentaRepository.findById(cuentaClienteDestino).orElse(null);

        if (cuentaOrigen == null || cuentaDestino == null) {
            throw new RuntimeException("verifique la existencia de las cuentas");
        }

        double saldoOrigen = cuentaOrigen.getAmount();

        if (saldoOrigen >= monto){

            // Cuenta Origen
            nuevoMontoCuentaOrigen = cuentaOrigen.getAmount() - monto;
            cuentaOrigen.setAmount(nuevoMontoCuentaOrigen);

            // Cuenta Destino
            nuevoMontoCuentaDestino = cuentaDestino.getAmount() + monto;
            cuentaDestino.setAmount(nuevoMontoCuentaDestino);

            // Guardo
            cuentaRepository.save(cuentaOrigen);
            cuentaRepository.save(cuentaDestino);

            //Guardo Transaccion
            Transaccion transaccion = new Transaccion(contador, cuentaOrigen.getId(), "transferencia", - monto, new Date());
            Transaccion transaccion2 = new Transaccion(contador+1, cuentaDestino.getId(), "transferencia", monto, new Date());
            transaccionRepository.save(transaccion);
            transaccionRepository.save(transaccion2);

        }else{
            throw new RuntimeException("Verifique el Saldo Disponible");
        }
        contador += 1;
        return cuentaOrigen;
    }

    public void cancelarCuenta(String cuentaCliente) {


        Cuenta cuentaBD = cuentaRepository.findById(cuentaCliente).orElse(null);

        if (cuentaBD == null) {
            throw new RuntimeException("No existe la Cuenta");
        }

        double saldo =  cuentaBD.getAmount();

        if ( saldo != 0){

            throw new RuntimeException("La Cuenta tiene Saldo");
        }

        cuentaRepository.deleteById(cuentaCliente);
    }
}

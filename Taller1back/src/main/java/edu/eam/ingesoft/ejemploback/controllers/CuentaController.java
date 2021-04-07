package edu.eam.ingesoft.ejemploback.controllers;

import edu.eam.ingesoft.ejemploback.model.Cuenta;
import edu.eam.ingesoft.ejemploback.model.Transaccion;
import edu.eam.ingesoft.ejemploback.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping("/accounts")
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta){ return cuentaService.crearCuenta(cuenta); }

    @GetMapping("/customers/{cedula}/accounts")
    public List<Cuenta> listarCuentasCliente(@PathVariable String cedula) {
        return cuentaService.listarCuentasCliente(cedula);
    }

    @PostMapping ("/accounts/consignacion/{cuentaCliente}/{monto}")
    public Cuenta consignacion (@PathVariable String cuentaCliente, @PathVariable double monto){
       return  cuentaService.consignacion(cuentaCliente, monto);
    }

    @PostMapping ("/accounts/retiro/{cuentaCliente}/{monto}")
    public Cuenta retiro (@PathVariable String cuentaCliente, @PathVariable double monto){
        return  cuentaService.retiro(cuentaCliente, monto);
    }

    @PostMapping("/accounts/transferencia/{cuentaClienteOrigen}/{cuentaClienteDestino}/{monto}")
    public Cuenta transferencia(@PathVariable String cuentaClienteOrigen, @PathVariable String cuentaClienteDestino, @PathVariable double monto){
        return cuentaService.transferencia(cuentaClienteOrigen, cuentaClienteDestino, monto);
    }

    @DeleteMapping("/accounts/{cuentaCliente}")
    public void cancelarCuenta(@PathVariable String cuentaCliente) {
        cuentaService.cancelarCuenta(cuentaCliente);
    }


}

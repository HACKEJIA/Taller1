package edu.eam.ingesoft.ejemploback.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaccion implements Serializable {

    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "accountid")
    private String cuentaCliente;

    @Column(name = "type")
    private String tipo;

    @Column(name = "amount")
    private double monto;

    @Column(name = "datetransaction")
    private Date fechaTransaccion;

    public Transaccion() {
        fechaTransaccion = new Date();
    }

    public Transaccion(Integer id, String accountid, String type, double amount, Date datetransaction) {
        this.id = id;
        this.cuentaCliente = accountid;
        this.tipo = type;
        this.monto = amount;
        this.fechaTransaccion = datetransaction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuentaCliente() {
        return cuentaCliente;
    }

    public void setCuentaCliente(String cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }
}

package com.examen.examen.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Reserva")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    @Column(name = "precioTotal", precision = 10, scale = 2)
    private BigDecimal precioTotal;

    @Column(name = "entregado", nullable = false)
    private boolean entregado;

    @Column(name = "fechaInicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fechaFinal", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;

    @ManyToOne
    @JoinColumn(name = "codigoCliente")
    private Cliente cliente;

     @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<ReservaAutomovil> reservaAutomoviles;
    
    // Constructores
    public Reserva() {
    }

    public Reserva(BigDecimal precioTotal, boolean entregado, Date fechaInicio, Date fechaFinal, Cliente cliente) {
        this.precioTotal = precioTotal;
        this.entregado = entregado;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.cliente = cliente;
    }

    // Getters y Setters
    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ReservaAutomovil> getReservaAutomoviles() {
        return reservaAutomoviles;
    }

    public void setReservaAutomoviles(List<ReservaAutomovil> reservaAutomoviles) {
        this.reservaAutomoviles = reservaAutomoviles;
    }
}
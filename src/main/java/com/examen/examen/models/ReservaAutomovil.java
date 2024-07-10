package com.examen.examen.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@IdClass(ReservaAutomovilId.class)
@Table(name = "Reserva_Automovil")
public class ReservaAutomovil {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idReserva")
    private Reserva reserva;

    @Id
    @ManyToOne
    @JoinColumn(name = "matricula")
    private Automovil automovil;

    @Column(name = "precioAlquiler", precision = 10, scale = 2)
    private BigDecimal precioAlquiler;

    @Column(name = "galonesGasolina", precision = 5, scale = 2)
    private BigDecimal galonesGasolina;
    
    // Constructores
    public ReservaAutomovil() {
    }

    public ReservaAutomovil(Reserva reserva, Automovil automovil, BigDecimal precioAlquiler, BigDecimal galonesGasolina) {
        this.reserva = reserva;
        this.automovil = automovil;
        this.precioAlquiler = precioAlquiler;
        this.galonesGasolina = galonesGasolina;
    }

    // Getters y Setters
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public BigDecimal getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(BigDecimal precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public BigDecimal getGalonesGasolina() {
        return galonesGasolina;
    }

    public void setGalonesGasolina(BigDecimal galonesGasolina) {
        this.galonesGasolina = galonesGasolina;
    }
}
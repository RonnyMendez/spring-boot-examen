package com.examen.examen.models;

import java.io.Serializable;
import java.util.Objects;

public class ReservaAutomovilId implements Serializable {

    private Long reserva;
    private String automovil;

    // Constructores, getters y setters

    public ReservaAutomovilId() {
    }

    public ReservaAutomovilId(Long reserva, String automovil) {
        this.reserva = reserva;
        this.automovil = automovil;
    }

    public Long getReserva() {
        return reserva;
    }

    public void setReserva(Long reserva) {
        this.reserva = reserva;
    }

    public String getAutomovil() {
        return automovil;
    }

    public void setAutomovil(String automovil) {
        this.automovil = automovil;
    }

    // Métodos equals() y hashCode() para comparar objetos ReservaAutomovilId

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservaAutomovilId that = (ReservaAutomovilId) o;
        return Objects.equals(reserva, that.reserva) &&
                Objects.equals(automovil, that.automovil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reserva, automovil);
    }
}
package com.examen.examen.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Garaje")
public class Garaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGaraje;

    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    // Constructores
    public Garaje() {
    }

    public Garaje(String direccion) {
        this.direccion = direccion;
    }

    // Getters y Setters
    public Long getIdGaraje() {
        return idGaraje;
    }

    public void setIdGaraje(Long idGaraje) {
        this.idGaraje = idGaraje;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
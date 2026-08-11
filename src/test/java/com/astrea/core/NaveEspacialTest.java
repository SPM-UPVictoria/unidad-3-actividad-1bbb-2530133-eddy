package com.astrea.core.base;

import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public abstract class NaveEspacial {

    private String matricula;
    private String modelo;
    private double combustible;
    private double capacidadCombustible;

    public NaveEspacial(
            String matricula,
            String modelo,
            double combustible,
            double capacidadCombustible)
            throws AstreaException {

        if (matricula == null || matricula.trim().isEmpty()) {
            throw new AstreaException(
                    "La matrícula no puede estar vacía."
            );
        }

        if (modelo == null || modelo.trim().isEmpty()) {
            throw new AstreaException(
                    "El modelo no puede estar vacío."
            );
        }

        if (capacidadCombustible <= 0) {
            throw new AstreaException(
                    "La capacidad de combustible debe ser positiva."
            );
        }

        if (combustible < 0) {
            throw new AstreaException(
                    "El combustible no puede ser negativo."
            );
        }

        if (combustible > capacidadCombustible) {
            throw new AstreaException(
                    "El combustible no puede superar la capacidad."
            );
        }

        this.matricula = matricula;
        this.modelo = modelo;
        this.combustible = combustible;
        this.capacidadCombustible = capacidadCombustible;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public double getCombustible() {
        return combustible;
    }

    public double getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void repostarCombustible(double cantidad)
            throws AstreaException {

        if (cantidad < 0) {
            throw new AstreaException(
                    "La cantidad no puede ser negativa."
            );
        }

        if (combustible + cantidad > capacidadCombustible) {
            throw new AstreaException(
                    "Se supera la capacidad de combustible."
            );
        }

        combustible += cantidad;
    }

    protected void consumirCombustible(double cantidad)
            throws AstreaException {

        if (cantidad < 0) {
            throw new AstreaException(
                    "La cantidad no puede ser negativa."
            );
        }

        if (cantidad > combustible) {
            throw new CombustibleInsuficienteException(
                    "Combustible insuficiente."
            );
        }

        combustible -= cantidad;
    }

    public abstract void viajar(double distancia)
            throws AstreaException;
}
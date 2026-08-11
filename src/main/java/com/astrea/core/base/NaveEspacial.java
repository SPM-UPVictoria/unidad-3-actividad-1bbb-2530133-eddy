package com.astrea.core.base;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public abstract class NaveEspacial {
    protected String matricula;
    protected String modelo;
    protected double combustible;
    protected double capacidadCombustible;

    public NaveEspacial(String matricula, String modelo, double combustibleInicial, double capacidadCombustible) throws AstreaException {
        if (matricula == null || matricula.isEmpty()) {
            throw new AstreaException("La matrícula no puede estar vacía.");
        }
        if (modelo == null || modelo.isEmpty()) {
            throw new AstreaException("El modelo no puede estar vacío.");
        }
        if (capacidadCombustible <= 0) {
            throw new AstreaException("La capacidad de combustible debe ser mayor que cero.");
        }
        if (combustibleInicial < 0 || combustibleInicial > capacidadCombustible) {
            throw new AstreaException("El combustible inicial debe estar entre 0 y la capacidad máxima.");
        }

        this.matricula = matricula;
        this.modelo = modelo;
        this.capacidadCombustible = capacidadCombustible;
        this.combustible = combustibleInicial;
    }

    public void repostarCombustible(double cantidad) throws AstreaException {
        if (cantidad <= 0) {
            throw new AstreaException("La cantidad a repostar debe ser positiva.");
        }
        if (combustible + cantidad > capacidadCombustible) {
            throw new AstreaException("No se puede exceder la capacidad máxima de combustible.");
        }
        combustible += cantidad;
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

    public abstract void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException, AstreaException;

    public void consumirCombustible(double cantidad) throws CombustibleInsuficienteException {
        if (cantidad <= 0) {
            throw new CombustibleInsuficienteException("La cantidad a consumir debe ser positiva.");
        }
        if (cantidad > combustible) {
            throw new CombustibleInsuficienteException("Combustible insuficiente para realizar la operación.");
        }
        combustible -= cantidad;
    }
}

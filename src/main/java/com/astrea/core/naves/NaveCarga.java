package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public class NaveCarga extends NaveEspacial {
    private double cargaActual;
    private double cargaMaxima;

    public NaveCarga(String matricula, String modelo, double combustibleInicial, double capacidadCombustible, double cargaMaxima) throws AstreaException {
        super(matricula, modelo, combustibleInicial, capacidadCombustible);

        if (cargaMaxima <= 0) {
            throw new AstreaException("La capacidad máxima de carga debe ser mayor que cero.");
        }
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = 0.0;
    }

    public void cargar(double cantidad) throws AstreaException {
        if (cantidad <= 0) {
            throw new AstreaException("La cantidad a cargar debe ser positiva.");
        }
        if (cargaActual + cantidad > cargaMaxima) {
            throw new AstreaException("La carga excede la capacidad máxima.");
        }
        cargaActual += cantidad;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    @Override
    public void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException, AstreaException {
        if (distanciaAniosLuz <= 0) {
            throw new AstreaException("La distancia debe ser positiva.");
        }

        // Ejemplo: consumo proporcional a la distancia y al peso de la carga
        double consumo = distanciaAniosLuz * (1 + (cargaActual / cargaMaxima));
        consumirCombustible(consumo);
    }
}

package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;

public class NaveCarga extends NaveEspacial {

    private double cargaActual;
    private double cargaMaxima;

    public NaveCarga(
            String matricula,
            String modelo,
            double combustibleInicial,
            double capacidadCombustible,
            double cargaMaxima) throws AstreaException {

        super(
                matricula,
                modelo,
                combustibleInicial,
                capacidadCombustible
        );

        if (cargaMaxima <= 0) {
            throw new AstreaException(
                    "La capacidad de carga debe ser mayor que cero."
            );
        }

        this.cargaMaxima = cargaMaxima;
        this.cargaActual = 0.0;
    }

    public void cargar(double cantidad) throws AstreaException {

        if (cantidad <= 0) {
            throw new AstreaException(
                    "La cantidad de carga debe ser mayor que cero."
            );
        }

        if (cargaActual + cantidad > cargaMaxima) {
            throw new AstreaException(
                    "La carga supera la capacidad máxima."
            );
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
    public void viajar(double distanciaAniosLuz)
            throws CombustibleInsuficienteException {

        if (distanciaAniosLuz < 0) {
            throw new IllegalArgumentException(
                    "La distancia no puede ser negativa."
            );
        }

        double consumoPorDistancia;

        if (cargaActual <= cargaMaxima * 0.50) {
            consumoPorDistancia = 1.5;
        } else {
            consumoPorDistancia = 3.0;
        }

        double consumo = consumoPorDistancia * distanciaAniosLuz;

        if (getCombustible() < consumo) {
            throw new CombustibleInsuficienteException(
                    "Combustible insuficiente para realizar el viaje."
            );
        }

        consumirCombustible(consumo);
    }
}
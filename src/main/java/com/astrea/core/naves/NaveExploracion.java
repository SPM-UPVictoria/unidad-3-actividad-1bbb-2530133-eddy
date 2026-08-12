package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;
import com.astrea.core.exceptions.FallaSistemasException;

import java.util.Random;

public class NaveExploracion extends NaveEspacial {

    private boolean hiperviajeListo;

    private static final double CONSUMO_VIAJE = 0.8;
    private static final double CONSUMO_HIPERVIAJE = 50.0;
    private static final double FACTOR_SEGURO = 9.0;
    private static final double PROBABILIDAD_FALLA = 0.30;

    public NaveExploracion(
            String matricula,
            String modelo,
            double combustibleInicial,
            double capacidadCombustible) throws AstreaException {

        super(
                matricula,
                modelo,
                combustibleInicial,
                capacidadCombustible
        );

        hiperviajeListo = true;
    }

    @Override
    public void viajar(double distanciaAniosLuz)
            throws CombustibleInsuficienteException {

        double consumo = CONSUMO_VIAJE * distanciaAniosLuz;

        if (getCombustible() < consumo) {
            throw new CombustibleInsuficienteException(
                    "Combustible insuficiente para realizar el viaje."
            );
        }

        try {
            consumirCombustible(consumo);
        } catch (AstreaException e) {
            throw new CombustibleInsuficienteException(
                    e.getMessage()
            );
        }
    }

    public void activarHiperviaje(double factor)
            throws AstreaException {

        // El hiperviaje siempre necesita 50 unidades.
        if (getCombustible() < CONSUMO_HIPERVIAJE) {
            throw new CombustibleInsuficienteException(
                    "Combustible insuficiente para activar el hiperviaje."
            );
        }

        // Factor <= 9: hiperviaje seguro.
        if (factor <= FACTOR_SEGURO) {

            consumirCombustible(CONSUMO_HIPERVIAJE);
            hiperviajeListo = true;

            return;
        }

        // Factor > 9: 30% de probabilidad de fallo.
        Random random = new Random();

        if (random.nextDouble() < PROBABILIDAD_FALLA) {

            hiperviajeListo = false;

            throw new FallaSistemasException(
                    "Falla de sistemas durante el hiperviaje."
            );
        }

        // Si no falla, consume las 50 unidades.
        consumirCombustible(CONSUMO_HIPERVIAJE);

        hiperviajeListo = true;
    }

    public boolean isHiperviajeListo() {
        return hiperviajeListo;
    }
}
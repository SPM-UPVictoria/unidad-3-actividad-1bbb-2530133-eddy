package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.interfaces.Defendible;
import com.astrea.core.interfaces.Atacable;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;
import com.astrea.core.exceptions.EscudoCriticoException;

public class NaveCombate extends NaveEspacial implements Defendible, Atacable {

    private double integridadEscudo;
    private double potenciaArma;

    public NaveCombate(
            String matricula,
            String modelo,
            double combustibleInicial,
            double capacidadCombustible,
            double potenciaArma) throws AstreaException {

        super(
                matricula,
                modelo,
                combustibleInicial,
                capacidadCombustible
        );

        this.integridadEscudo = 200.0;
        this.potenciaArma = potenciaArma;
    }

    public double getIntegridadEscudo() {
        return integridadEscudo;
    }

    public double getPotenciaArma() {
        return potenciaArma;
    }

    @Override
    public void viajar(double distanciaAniosLuz)
            throws CombustibleInsuficienteException {

        double consumo = distanciaAniosLuz * 2.0;

        if (getCombustible() < consumo) {
            throw new CombustibleInsuficienteException(
                    "Combustible insuficiente para realizar el viaje."
            );
        }

        consumirCombustible(consumo);
    }

    @Override
    public void recibirImpacto(double potenciaDano)
            throws EscudoCriticoException {

        integridadEscudo -= potenciaDano;

        if (integridadEscudo < 50.0) {
            throw new EscudoCriticoException(
                    "La integridad del escudo es crítica."
            );
        }
    }

    @Override
    public void atacar(Defendible objetivo)
            throws AstreaException {

        double consumoAtaque = 15.0;

        if (getCombustible() < consumoAtaque) {
            throw new CombustibleInsuficienteException(
                    "Combustible insuficiente para atacar."
            );
        }

        consumirCombustible(consumoAtaque);

        objetivo.recibirImpacto(potenciaArma);
    }
}
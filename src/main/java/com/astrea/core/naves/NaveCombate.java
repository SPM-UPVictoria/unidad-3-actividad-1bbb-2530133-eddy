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

    public NaveCombate(String matricula, String modelo, double combustibleInicial, double capacidadCombustible, double potenciaArma) throws AstreaException {
        super(matricula, modelo, combustibleInicial, capacidadCombustible);
        // TODO: Implementar asignación
    }

    public double getIntegridadEscudo() {
        return 0.0; // TODO: Implementar
    }

    public double getPotenciaArma() {
        return 0.0; // TODO: Implementar
    }

    @Override
    public void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException {
        // TODO: Implementar lógica
    }

    @Override
    public void recibirImpacto(double potenciaDano) throws EscudoCriticoException {
        // TODO: Implementar lógica
    }

    @Override
    public void atacar(Defendible objetivo) throws AstreaException {
        // TODO: Implementar lógica
    }
	public void consumirCombustible(double cantidad) {
    // lógica para reducir combustible
}

}

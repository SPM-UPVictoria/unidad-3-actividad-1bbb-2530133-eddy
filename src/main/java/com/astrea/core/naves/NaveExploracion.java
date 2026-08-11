package com.astrea.core.naves;

import com.astrea.core.base.NaveEspacial;
import com.astrea.core.interfaces.Propulsable;
import com.astrea.core.exceptions.AstreaException;
import com.astrea.core.exceptions.CombustibleInsuficienteException;
import com.astrea.core.exceptions.FallaSistemasException;

public class NaveExploracion extends NaveEspacial implements Propulsable {
    private double integridadEscudo;
    private boolean hiperviajeListo;

    public NaveExploracion(String matricula, String modelo, double combustibleInicial, double capacidadCombustible) throws AstreaException {
        super(matricula, modelo, combustibleInicial, capacidadCombustible);
        // TODO: Implementar asignación
    }

    public double getIntegridadEscudo() {
        return 0.0; // TODO: Implementar
    }

    public boolean isHiperviajeListo() {
        return false; // TODO: Implementar
    }

    @Override
    public void viajar(double distanciaAniosLuz) throws CombustibleInsuficienteException {
        // TODO: Implementar lógica
    }

    @Override
    public void activarHiperviaje(double factorWarp) throws FallaSistemasException, CombustibleInsuficienteException {
        // TODO: Implementar lógica probabilística y de consumo
    }
	
	public void consumirCombustible(double cantidad) {
    // lógica para reducir combustible
}

}

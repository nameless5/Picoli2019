package control;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.Factorias;
import modelo.poblacion.Seres;

public class Estado {

	Factorias factoria;
	Poblacion poblacion;
	Sede sede;

	private double demanda;
	private int numeroSeres;
	private double dineroActual;

	public Estado(double demanda, int numeroSeres, double dineroActual) {
		super();
		this.demanda = demanda;
		this.numeroSeres = numeroSeres;
		this.dineroActual = dineroActual;
	}

	public boolean isFallecido(Seres seres) {
		boolean resultado = false;
		if (seres.getEdad() >= seres.getEsperanzaVida()) {
			resultado = true;
		}
		return resultado;
	}

	public void eliminarFallecidos(ArrayList<Seres> poblacion, ArrayList<Seres> jubilados) {
		for (int i = 0; i < poblacion.size(); i++) {
			Seres persona = poblacion.get(i);
			if (isFallecido(persona)) {
				poblacion.remove(persona);
				if (jubilados.contains(persona)) {
					float ahorro = persona.getAhorro();
					jubilados.remove(persona);
					setDineroActual((int) (this.dineroActual + ahorro));

				}
			}
		}
	}

	public void setDineroActual(int dineroActual) {
		this.dineroActual = dineroActual;
	}

	public float pagarTrabajador() {
		return 1;
	}

	public void comprobarPorcentajeTrabajadores() {
		// TODO
	}

	public double getDemanda() {
		return demanda;
	}

	public int getNumeroSeres() {
		return numeroSeres;
	}

	public double getDineroActual() {
		return dineroActual;
	}

	public void contratarTrabajador(ArrayDeque<Seres> demandantes, Stack<Seres> pilaTrabajador) {
		// if(getDemanda()>factoria.getProduccion()) { /*Hay que obtener el numero
		// concreto de gente a emplear*/
		Seres contratado = demandantes.poll();
		pilaTrabajador.push(contratado);
	}
}
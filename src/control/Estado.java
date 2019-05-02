package control;

import java.util.ArrayDeque;
import java.util.Stack;

import modelo.empresa.Factorias;
import modelo.poblacion.Seres;

public class Estado {
	
	Factorias factoria;
	Poblacion poblacion;
	
	private float demanda;
	private int numeroSeres;
	private int dineroActual;

	public Estado(float demanda, int numeroSeres, int dineroActual) {
		super();
		this.demanda = demanda;
		this.numeroSeres = numeroSeres;
		this.dineroActual = dineroActual;
	}

	public boolean fallecimiento(Seres seres) {
		boolean resultado = false;
		if (seres.getEdad() >= seres.getEsperanzaVida()) {
			resultado = true;
			return resultado;
		}
		return resultado;
	}
	

	public float pagarTrabajador() {
		return 1;
	}

	public void comprobarPorcentajeTrabajadores() {
		// TODO
	}

	public float getDemanda() {
		return demanda;
	}

	public int getNumeroSeres() {
		return numeroSeres;
	}

	public int getDineroActual() {
		return dineroActual;
	}
	
	public void contratarTrabajador(ArrayDeque<Seres> demandantes, Stack<Seres> pilaTrabajador) {
		//if(getDemanda()>factoria.getProduccion()) { /*Hay que obtener el numero concreto de gente a emplear*/
			Seres contratado = demandantes.poll();
			pilaTrabajador.push(contratado);
		//}
		
	}
	
	public void jubilarTrabajador(Stack<Seres> pilaTrabajador) {
		for (int i = 0; i < pilaTrabajador.size(); i++) {
			int edad = pilaTrabajador.get(i).getEdad();
			if(edad>=65) {
				pilaTrabajador.remove(i);
			}
		}
	}
	
}
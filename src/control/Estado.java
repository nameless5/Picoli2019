package control;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.Factorias;
import modelo.poblacion.EstadoSer;
import modelo.poblacion.Seres;

public class Estado {

	Factorias factoria;
	Poblacion poblacion;
	Sede sede;

	private double demanda;
	private int numeroSeres;
	private double dineroActual;

	public Estado() {
		super();
		//revisar esto
		this.demanda = demanda;
		this.dineroActual = dineroActual;
	}

	public int obtenerAhorros(ArrayList<Seres> fallecidos, int dineroActual) {
		fallecidos.clear();
		for (int i = 0; i < fallecidos.size(); i++) {
			float ahorro = fallecidos.get(i).getAhorro();
			dineroActual = (int) (dineroActual + ahorro);
		}
		return dineroActual;	
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

	public void jubilarTrabajador(Stack<Seres> pilaTrabajador, ArrayDeque<Seres> demandantes) {
		for (int i = 0; i < pilaTrabajador.size(); i++) {
			int edad = pilaTrabajador.get(i).getEdad();
			if(edad>=65) {
				pilaTrabajador.remove(i);
			}
		}
		
		for (Iterator iterator = demandantes.iterator(); iterator.hasNext();) {
			Seres seres = (Seres) iterator.next();
			int edad = seres.getEdad();
			if(edad>=65) {
				demandantes.remove(seres);
			}
		}
	}
}

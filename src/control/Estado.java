package control;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.DineroEstado;
import modelo.empresa.Factorias;
import modelo.poblacion.Seres;

public class Estado {

	Factorias factoria;
	Poblacion poblacion;
	DineroEstado dinero;
	Sede sede;

	private double demanda;

	public Estado() {
		super();
		this.poblacion = new Poblacion(50, 100, 30);
		this.sede = new Sede();
		this.dinero = new DineroEstado(100000);
	}

	public void pasarPeriodo() {
		sede.produccionTotal();
		factoria.pagarTrabajador(dinero);
		
	}

	public double getDemanda() {
		return demanda;
	}


	

	public void contratarTrabajador(ArrayDeque<Seres> demandantes, Stack<Seres> pilaTrabajador) {
		// if(getDemanda()>factoria.getProduccion()) { /*Hay que obtener el numero
		// concreto de gente a emple*(
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

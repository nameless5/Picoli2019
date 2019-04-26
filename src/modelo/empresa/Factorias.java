package modelo.empresa;

import java.util.Stack;

import modelo.poblacion.Seres;

public class Factorias {
	private float produccion;
	private Stack<Seres> pilaTrabajador;

	public Factorias() {
		super();
		this.pilaTrabajador = new Stack<Seres>();
	}

	public float getProduccion() {
		return produccion;
	}

	public Stack<Seres> getPilaTrabajador() {
		return pilaTrabajador;
	}

}

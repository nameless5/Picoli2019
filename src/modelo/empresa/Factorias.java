package modelo.empresa;

import java.util.Stack;

import modelo.poblacion.Seres;

public class Factorias {
	private float produccion = 1000;
	private Stack<Seres> pilaTrabajador;

	public Factorias() {
		super();
		this.pilaTrabajador = new Stack<Seres>();
	}

	public float comprobarProduccion(Stack<Seres> pilaTrabajador) {
		int produccionPersona = 1000;
		this.produccion = pilaTrabajador.size() * produccionPersona;
		return produccion;
	}

	public float getProduccion() {
		return produccion;
	}

	public Stack<Seres> getPilaTrabajador() {
		return pilaTrabajador;
	}

	public void setProduccion(float produccion) {
		this.produccion = produccion;
	}

	public void setPilaTrabajador(Stack<Seres> pilaTrabajador) {
		this.pilaTrabajador = pilaTrabajador;
	}

}

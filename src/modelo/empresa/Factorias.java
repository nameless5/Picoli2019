package modelo.empresa;

import java.util.Stack;

import modelo.poblacion.Seres;

public class Factorias {
	private int produccionEmpleado=1000;
	private Stack<Seres> pilaTrabajador;

	public Factorias() {
		super();
		this.pilaTrabajador = new Stack<Seres>();
	}
//hola
	public int  comprobarProduccion() {
		 int produccion = pilaTrabajador.size() * this.produccionEmpleado;
		return produccion;
	}
	
	public int numeroTrabajadores() {
		int empleados;
		empleados = 1000 - this.pilaTrabajador.size();
		return empleados;
		
	}

	public int getProduccion() {
		return produccionEmpleado;
	}

	public Stack<Seres> getPilaTrabajador() {
		return pilaTrabajador;
	}

	public void setPilaTrabajador(Stack<Seres> pilaTrabajador) {
		this.pilaTrabajador = pilaTrabajador;
	}

}

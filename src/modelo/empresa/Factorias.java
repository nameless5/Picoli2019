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
	public void pagarTrabajador(DineroEstado dinero) {
		float cobroLimpioCadaTrabajador = (float) (this.pilaTrabajador.get(0).getTipoEstado().getSueldo() - this.pilaTrabajador.get(0).getTipoEstado().getNivelVida()/2);
		for (int i = 0; i < this.pilaTrabajador.size(); i++) {
			float suma = this.pilaTrabajador.get(i).getAhorro() + cobroLimpioCadaTrabajador;
			this.pilaTrabajador.get(i).setAhorro(suma);
		}
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

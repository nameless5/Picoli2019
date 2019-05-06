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
		float pagar= (float) (this.pilaTrabajador.get(0).getTipoEstado().getSueldo());
		float impuesto=this.pilaTrabajador.get(0).getTipoEstado().getNivelVida()/2;
		float nv = this.pilaTrabajador.get(0).getTipoEstado().getNivelVida();
		float cobroLimpioCadaTrabajador = pagar - impuesto - nv;
		for (int i = 0; i < pilaTrabajador.size(); i++) {
			float suma=pilaTrabajador.get(i).getAhorro() + cobroLimpioCadaTrabajador;
			pilaTrabajador.get(i).setAhorro(suma);
			dinero.setDineroTotal(dinero.getDineroTotal() - cobroLimpioCadaTrabajador);
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

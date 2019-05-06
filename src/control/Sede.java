package control;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.Factorias;
import modelo.poblacion.Seres;

public class Sede {
	private ArrayList<Factorias> factorias;

	public Sede() {
		super();
		this.factorias = new ArrayList<>();
	}

	public void crearFactoria() {
		this.factorias.add(new Factorias());
	}

	public void eliminarEmpresasEmpty() {
		for (Iterator iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias factoria = (Factorias) iterator.next();
			if (factoria.getPilaTrabajador().isEmpty()) {
				iterator.remove();
			}
		}
	}

	public int produccionTotal() {
		int produccion = 0;
		for (Factorias factoria : factorias) {
			factoria.comprobarProduccion();
		}
		return produccion;
	}

	public void contratarTrabajador(ArrayDeque<Seres> demandantes, Stack<Seres> pilaTrabajador) {
		// if(getDemanda()>factoria.getProduccion()) { /*Hay que obtener el numero
		// concreto de gente a emplear*/
		Seres contratado = demandantes.poll();
		pilaTrabajador.push(contratado);
    
	}
	
	public void pagarTrabajador(Stack<Seres> pilaTrabajador,Estado estado) {
		float pagar=730f;
		float impuesto=182.5f;
		float cobroLimpioCadaTrabajador=pagar-impuesto;
		for (int i = 0; i < pilaTrabajador.size(); i++) {
			float suma=pilaTrabajador.get(i).getAhorro() + cobroLimpioCadaTrabajador;
			pilaTrabajador.get(i).setAhorro(suma);
			double dineroEstado = estado.getDineroActual()-cobroLimpioCadaTrabajador+impuesto;
			estado.setDineroActual(estado.getDineroActual()+dineroEstado);
		}
	}
	
	public ArrayList<Factorias> eliminarJubilados(ArrayList<Integer> listaJubilados) {
		for (Iterator iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias factoria = (Factorias) iterator.next();
			for (Iterator iterator2 = factoria.getPilaTrabajador().iterator(); iterator2.hasNext();) {
				Seres ser = (Seres) iterator2.next();
				if (listaJubilados.contains(ser.getId())) {
					iterator2.remove();
				}
			}
		}
		return factorias;
	}

	public void numTrabajadores() {
		int contador = 0;
		for (Factorias factoria : factorias) {
			contador = contador + factoria.getPilaTrabajador().size();
		}
	}

	public ArrayList<Factorias> getFactorias() {
		return factorias;
	}

	public void setFactorias(ArrayList<Factorias> factorias) {
		this.factorias = factorias;
	}
}
package control;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.DineroEstado;
import modelo.empresa.Factorias;
import modelo.poblacion.Seres;

public class Sede {
	private ArrayList<Factorias> factorias;

	public Sede() {
		super();
		this.factorias = new ArrayList<>();
	}

	public boolean crearFactoria() {
		return this.factorias.add(new Factorias());
	}

	public void eliminarEmpresasEmpty() {
		for (Iterator iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias factoria = (Factorias) iterator.next();
			if (factoria.getPilaTrabajador().isEmpty()) {
				iterator.remove();
			}
		}
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


	public void contratarDesempleados(ArrayList<Seres> desempleados) {
		for (Iterator iterator = desempleados.iterator(); iterator.hasNext();) {
			Seres ser = (Seres) iterator.next();
			for (Iterator iterator2 = this.factorias.iterator(); iterator2.hasNext();) {
				Factorias factoria = (Factorias) iterator2.next();
				if (factoria.numeroTrabajadores() > 0) {
					factoria.setContratarTrabajador(ser);
					break;
				}
			}
		}
	}

	public int numTrabajadores() {
		int contador = 0;
		for (Factorias factoria : factorias) {
			contador = contador + factoria.getPilaTrabajador().size();
		}
		return contador;
	}

	public int puestosVacantes() {
		int libres = 0;
		for (Factorias factoria : this.factorias) {
			libres += factoria.numeroTrabajadores();
		}
		return libres;
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

	private int numTrabajadores() {
		int contador = 0;
		for (Factorias factoria : factorias) {
			contador = contador + factoria.getPilaTrabajador().size();
		}
		return contador;
	}

	public void gestionarCierreFactorias(ArrayDeque<Seres> demandantes) {
		int ocupacionMaxima = 1000;
		for (Iterator iterator = factorias.iterator(); iterator.hasNext();) {
			Factorias empresa = (Factorias) iterator.next();
			int numTrabajadores = empresa.getPilaTrabajador().size();
			float porcentajeOcupado = (numTrabajadores * 100) / ocupacionMaxima;
			if (porcentajeOcupado <= 0.3) {
				despedirTrabajadores(demandantes, empresa);
				factorias.remove(empresa);
			}

		}

	}

	private void despedirTrabajadores(ArrayDeque<Seres> demandantes, Factorias empresa) {
		for (int i = 0; i < empresa.getPilaTrabajador().size(); i++) {
			Seres trabajador = empresa.getPilaTrabajador().pop();
			demandantes.offer(trabajador);
		}
	}

	public ArrayList<Factorias> getFactorias() {
		return factorias;
	}

	public void setFactorias(ArrayList<Factorias> factorias) {
		this.factorias = factorias;
	}
}
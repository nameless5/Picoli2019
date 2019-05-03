package control;

import java.util.ArrayList;

import modelo.empresa.Factorias;

public class Sede {
	private ArrayList<Factorias> factorias;

	public Sede(ArrayList<Factorias> factorias) {
		super();
		this.factorias = new ArrayList<>();
	}

	public void crearFactoria() {
		this.factorias.add(new Factorias());
	}

	public int produccionTotal() {
		int produccion = 0;
		for (Factorias factoria : factorias) {
			factoria.comprobarProduccion();
		}
		return produccion;
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

	public ArrayList<Factorias> jubilar(ArrayList<Factorias> sedes) {
	
		return sedes;
	}

}

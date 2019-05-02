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
	

	public ArrayList<Factorias> getFactorias() {
		return factorias;
	}

	public void setFactorias(ArrayList<Factorias> factorias) {
		this.factorias = factorias;
	}

}

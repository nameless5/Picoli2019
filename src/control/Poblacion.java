package control;

import java.util.ArrayList;

import modelo.poblacion.Seres;

public class Poblacion {

	private ArrayList<Seres> menores;
	private ArrayList<Seres> jubilados;
	private ArrayList<Seres> poblacion;

	public Poblacion() {
		menores = new ArrayList<>();
		jubilados = new ArrayList<>();
		poblacion = new ArrayList<>();
	}

	public Seres generadorCiudadanos(Seres seres, ArrayList<Seres> menores) {
		Seres ciudadano = new Seres();
		añadirMenorCreadoAlaLista(ciudadano, menores);
		añadirCiudadanoCreadoAlaLista(ciudadano, poblacion);
		/*Revisión: Se añaden a las dos listas del tirón*/
		return ciudadano;
	}

	private void añadirMenorCreadoAlaLista(Seres ciudadano, ArrayList<Seres> menores) {
		menores.add(ciudadano);
	}
	private void añadirCiudadanoCreadoAlaLista(Seres ciudadano, ArrayList<Seres> poblacion) {
		poblacion.add(ciudadano);
	}
}

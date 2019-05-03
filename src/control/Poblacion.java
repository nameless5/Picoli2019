package control;

import java.util.ArrayDeque;
import java.util.ArrayList;

import modelo.poblacion.EstadoSer;
import modelo.poblacion.Seres;
import utilesglobal.Utilies;

public class Poblacion {

	private ArrayList<Seres> menores;
	private ArrayList<Seres> jubilados;
	private ArrayList<Seres> poblacion;
	private ArrayDeque<Seres> demandantes;

	public Poblacion() {
		int menoresInicial = 30, trabajadoresIncial = 100, jubiladosInicial = 20;
		menores = new ArrayList<>();
		jubilados = new ArrayList<>();
		poblacion = new ArrayList<>();
		demandantes = new ArrayDeque<>();

		for (int i = 0; i < menoresInicial; i++) {
			poblacion.add(new Seres(Utilies.obtenerAleatorio(0, 17), EstadoSer.menor));
		}
		for (int i = 0; i < trabajadoresIncial; i++) {
			poblacion.add(new Seres(Utilies.obtenerAleatorio(18, 65), EstadoSer.trabajador));
		}
		for (int i = 0; i < jubiladosInicial; i++) {
			poblacion.add(new Seres(65, EstadoSer.jubilado));
		}
	}

	public Seres generadorCiudadanos(Seres seres, ArrayList<Seres> menores) {
		Seres ciudadano = new Seres();
		añadirMenorCreadoAlaLista(ciudadano, menores);

		/* Revisión, también hay que añadirlo a la lista principal */

		añadirCiudadanoCreadoAlaLista(ciudadano, poblacion);
		/* Revisión: Se añaden a las dos listas del tirón */

		return ciudadano;
	}

	private void añadirMenorCreadoAlaLista(Seres ciudadano, ArrayList<Seres> menores) {
		menores.add(ciudadano);
	}

	private void añadirCiudadanoCreadoAlaLista(Seres ciudadano, ArrayList<Seres> poblacion) {
		poblacion.add(ciudadano);
	}

	public void envejecer() {
		for (Seres ser : this.poblacion) {
			ser.setEdad(ser.getEdad() + 1);

		}
	}
}

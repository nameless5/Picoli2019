package control;

import java.util.ArrayDeque;
import java.util.ArrayList;

import modelo.poblacion.EstadoSer;
import modelo.poblacion.Seres;

public class Poblacion {

	private ArrayList<Seres> menores;
	private ArrayList<Seres> jubilados;
	private ArrayList<Seres> poblacion;
	private ArrayDeque<Seres> demandantes;

	public Poblacion() {
		menores = new ArrayList<>();
		jubilados = new ArrayList<>();
		poblacion = new ArrayList<>();
	}

	public Seres generadorCiudadanos(Seres seres, ArrayList<Seres> menores) {
		Seres ciudadano = new Seres();
		añadirMenorCreadoAlaLista(ciudadano, menores);
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

	private void establecerDestinoCiudadano(ArrayList<Seres> poblacion) {
		for (int i = 0; i < poblacion.size(); i++) {
			int valor = poblacion.get(i).getEdad();
			int respuesta = getRespuesta(valor);
			switch (respuesta) {
			case 0:
				poblacion.get(i).setTipoEstado(EstadoSer.menor);
				menores.add(poblacion.get(i));
				break;
			case 1:
				poblacion.get(i).setTipoEstado(EstadoSer.desempleado);
				demandantes.offer(poblacion.get(i));
				break;
			case 2:
				poblacion.get(i).setTipoEstado(EstadoSer.jubilado);
				jubilados.add(poblacion.get(i));
				
			default:
				break;
			}
		}
	}

	private int getRespuesta(int valor) {
		int respuesta;
		if (valor < 18) {
			respuesta = 0;
		} else {
			if (valor > 65) {
				respuesta = 2;
			} else {
				respuesta = 1;
			}
		}
		return respuesta;
	}
}

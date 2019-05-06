package control;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.poblacion.EstadoSer;
import modelo.poblacion.Seres;
import utilesglobal.Utilies;

public class Poblacion {

	private ArrayList<Seres> menores;
	private ArrayList<Seres> jubilados;
	private ArrayList<Seres> poblacion;
	private ArrayDeque<Seres> demandantes;
	private ArrayList<Integer> recienJubilados;

	public Poblacion() {
		int menoresInicial = 30, trabajadoresIncial = 100, jubiladosInicial = 20;
		menores = new ArrayList<>();
		jubilados = new ArrayList<>();
		poblacion = new ArrayList<>();
		demandantes = new ArrayDeque<>();
		recienJubilados = new ArrayList<>();

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

	public void cambiarTipoHabitante() {
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getEdad() < 18) {
				poblacion.get(i).setTipoEstado(EstadoSer.menor);
			}
		}
	}

	public void generadorCiudadanos(int numeroCiudadanos) {
		for (int i = 0; i < numeroCiudadanos; i++) {
			Seres ciudadano = new Seres();
			aniadirMenorCreadoAlaLista(ciudadano);
			aniadirCiudadanoCreadoAlaLista(ciudadano);
		}
		/* Revisión, también hay que añadirlo a la lista principal */
		/* Revisión: Se añaden a las dos listas del tirón */
	}

	private void aniadirMenorCreadoAlaLista(Seres ciudadano) {
		menores.add(ciudadano);
	}

	private void aniadirCiudadanoCreadoAlaLista(Seres ciudadano) {
		
		poblacion.add(ciudadano);
	}

	public void envejecer() {
		for (Seres ser : this.poblacion) {
			ser.setEdad(ser.getEdad() + 1);

		}
	}
	

	public boolean isFallecido() {
		boolean resultado = false;
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getEdad() >= poblacion.get(i).getEsperanzaVida()) {
				resultado = true;
			}
		}
		return resultado;
	}

	public ArrayList<Integer> jubilarTrabajador() {
		this.recienJubilados.clear();
		for (int i = 0; i < poblacion.size(); i++) {
			Seres persona = poblacion.get(i);
			if (persona.getEdad() >= 65 && (persona.getTipoEstado() == EstadoSer.trabajador
					|| persona.getTipoEstado() == EstadoSer.desempleado)) {
				recienJubilados.add(persona.getId());
				persona.setTipoEstado(EstadoSer.jubilado);
			}
		}
		for (Iterator iterator = demandantes.iterator(); iterator.hasNext();) {
			Seres ser = (Seres) iterator.next();
			if (recienJubilados.contains(ser.getId())) {
				iterator.remove();
			}
		}

		return recienJubilados;

	}

	public float pagarTrabajador() {
		return 1;
	}

	public void pagarNV(ArrayList<Seres> poblacion, EstadoSer estadoSer, Estado estado) {
		pagarNVMenores(poblacion, estadoSer, estado);
		pagarDemandantes(poblacion, estadoSer, estado);
		pagarJubilados(poblacion, estadoSer, estado);

	}

	public void pagarNVMenores(ArrayList<Seres> poblacion, EstadoSer estadoSer, Estado estado) {
		// Dinero que se le da a cada menor y se acumula en el ahorro
		float nv = estadoSer.menor.getNivelVida();
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(poblacion, estadoSer.menor, contador);
		dineroTotalPagar = contador * nv;
		if (estado.getDineroActual() >= dineroTotalPagar) {
			for (int i = 0; i < poblacion.size(); i++) {
				if (estadoSer.menor == poblacion.get(i).getTipoEstado()) {
					poblacion.get(i).setAhorro(nv);
				}
			}
		} else {
			float reparto = (float) (estado.getDineroActual() / menores.size());
			for (int i = 0; i < poblacion.size(); i++) {
				if (estadoSer.menor == poblacion.get(i).getTipoEstado()) {
					poblacion.get(i).setAhorro(reparto);
				}
			}
		}
	}

	private int contarTipoPersona(ArrayList<Seres> poblacion, EstadoSer estado, int contador) {
		for (int i = 0; i < poblacion.size(); i++) {
			if (estado == poblacion.get(i).getTipoEstado()) {
				contador++;
			}
		}
		return contador;
	}

	public void pagarDemandantes(ArrayList<Seres> poblacion, EstadoSer estadoSer, Estado estado) {
		// Dinero que se le da a cada demandante y se acumula en el ahorro
		float nv = estadoSer.desempleado.getNivelVida();
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(poblacion, estadoSer.desempleado, contador);
		dineroTotalPagar = contador * nv / 2;
		if (estado.getDineroActual() >= dineroTotalPagar) {
			for (int i = 0; i < poblacion.size(); i++) {
				if (estadoSer.desempleado == poblacion.get(i).getTipoEstado()) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + dineroTotalPagar);
				}
			}
		} else {
			float reparto = (float) (estado.getDineroActual() / contador);
			for (int i = 0; i < poblacion.size(); i++) {
				if (estadoSer.desempleado == poblacion.get(i).getTipoEstado()) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + reparto);
				}
			}
		}
	}

	private float pedirAhorro(ArrayList<Seres> poblacion, int i) {
		return poblacion.get(i).getAhorro();
	}

	public void pagarJubilados(ArrayList<Seres> poblacion, EstadoSer estadoSer, Estado estado) {
		// Dinero que se le da a cada jubilado y se acumula en el ahorro
		float nv = estadoSer.jubilado.getNivelVida();
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(poblacion, estadoSer.jubilado, contador);
		dineroTotalPagar = deberJubilados(poblacion, estadoSer, estado);
		if (estado.getDineroActual() >= dineroTotalPagar) {
			for (int i = 0; i < poblacion.size(); i++) {
				if (estadoSer.jubilado == poblacion.get(i).getTipoEstado()) {
					if (pedirAhorro(poblacion, i) < nv) {
						float pagar = nv - pedirAhorro(poblacion, i);
						poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + pagar);
					}
				}
			}
		} else {
			float reparto = (float) (estado.getDineroActual() / contarJubiladosMorosos(poblacion, estadoSer, estado));
			for (int i = 0; i < poblacion.size(); i++) {
				if (estadoSer.jubilado == poblacion.get(i).getTipoEstado() && pedirAhorro(poblacion, i) < nv) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + reparto);
				}
			}
		}
	}

	public float deberJubilados(ArrayList<Seres> poblacion, EstadoSer estadoSer, Estado estado) {
		int contador = 0;
		float nv = estadoSer.jubilado.getNivelVida();
		float acumulador = 0;
		contador = contarTipoPersona(poblacion, estadoSer.jubilado, contador);
		for (int i = 0; i < poblacion.size(); i++) {
			if (estadoSer.jubilado == poblacion.get(i).getTipoEstado()) {
				if (pedirAhorro(poblacion, i) < nv) {
					float diferencia = nv - pedirAhorro(poblacion, i);
					acumulador += diferencia;
				}
			}
		}
		return acumulador;

	}

	public int contarJubiladosMorosos(ArrayList<Seres> poblacion, EstadoSer estadoSer, Estado estado) {
		float nv = estadoSer.jubilado.getNivelVida();
		int morosos = 0;
		for (int i = 0; i < poblacion.size(); i++) {
			if (estadoSer.jubilado == poblacion.get(i).getTipoEstado()) {
				if (poblacion.get(i).getAhorro() < nv) {
					morosos++;
				}
			}
		}
		return morosos;
	}
}

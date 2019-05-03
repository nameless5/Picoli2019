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

	public Poblacion(int menoresInicial, int trabajadoresIncial, int jubiladosInicial) {
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

	private void establecerDestinoCiudadano(ArrayList<Seres> poblacion) {
		for (int i = 0; i < poblacion.size(); i++) {
			int valor = poblacion.get(i).getEdad();
			int respuesta = getRespuesta(valor);
			switch (respuesta) {
			case 0:
				for (int j = 0; j < menores.size(); j++) {
					if (!menores.contains(poblacion.get(i))) {
						poblacion.get(i).setTipoEstado(EstadoSer.menor);
						menores.add(poblacion.get(i));
					}
				}
				break;
			case 1:
				for (int j = 0; j < demandantes.size(); j++) {
					if (!demandantes.contains(poblacion.get(i))) {
						poblacion.get(i).setTipoEstado(EstadoSer.desempleado);
						demandantes.offer(poblacion.get(i));
					}
				}
				break;
			case 2:
				for (int j = 0; j < jubilados.size(); j++) {
					if (!jubilados.contains(poblacion.get(i))) {
						poblacion.get(i).setTipoEstado(EstadoSer.jubilado);
						jubilados.add(poblacion.get(i));
					}
				}
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

	public void envejecer() {
		for (Seres ser : this.poblacion) {
			ser.setEdad(ser.getEdad() + 1);

		}
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
			float reparto = estado.getDineroActual() / menores.size();
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
			float reparto = estado.getDineroActual() / contador;
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
			float reparto = estado.getDineroActual() / contarJubiladosMorosos(poblacion, estadoSer, estado);
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

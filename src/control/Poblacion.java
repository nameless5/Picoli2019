package control;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.DineroEstado;
import modelo.poblacion.EstadoSer;
import modelo.poblacion.Seres;
import utilesglobal.Utilies;

public class Poblacion {

	private ArrayList<Seres> menores;
	private ArrayList<Seres> jubilados;
	private ArrayList<Seres> poblacion;
	private ArrayDeque<Seres> demandantes;
	private ArrayList<Integer> recienJubilados;
	private ArrayList<Seres> fallecidos;
	private ArrayList<Seres> mayoresEdad;

	public Poblacion(int menoresInicial, int trabajadoresIncial, int jubiladosInicial) {
		menores = new ArrayList<>();
		jubilados = new ArrayList<>();
		poblacion = new ArrayList<>();
		demandantes = new ArrayDeque<>();
		recienJubilados = new ArrayList<>();
		fallecidos = new ArrayList<>();
		mayoresEdad = new ArrayList<>();

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
	
	public double obtenerAhorros(DineroEstado dinero) {
		fallecidos.clear();
		for (int i = 0; i < fallecidos.size(); i++) {
			float ahorro = fallecidos.get(i).getAhorro();
			dinero.setDineroTotal(dinero.getDineroTotal()+ahorro);
		}
		return dinero.getDineroTotal();
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

	public ArrayList<Seres> mayoresDeEdad() {
		mayoresEdad.clear();
		for (int i = 0; i < menores.size(); i++) {
			Seres persona = menores.get(i);
			if (persona.getTipoEstado() == EstadoSer.desempleado) {
				mayoresEdad.add(persona);
				menores.remove(persona);
			}

		}

		return mayoresEdad;
	}

	public void annadirMayoresEdad() {
		for (int i = 0; i < mayoresEdad.size(); i++) {
			demandantes.add(mayoresEdad.get(i));
		}
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

	public void pagarNV(DineroEstado dinero) {
		pagarNVMenores(dinero);
		pagarDemandantes(dinero);
		pagarJubilados(dinero);

	}

	public void pagarNVMenores(DineroEstado dinero) {
		// Dinero que se le da a cada menor y se acumula en el ahorro
		float nv = menores.get(0).getTipoEstado().getNivelVida();
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(menores.get(0).getTipoEstado(), contador);
		dineroTotalPagar = contador * nv;
		if (dinero.getDineroTotal() >= dineroTotalPagar) {
			for (int i = 0; i < this.poblacion.size(); i++) {
				if (this.poblacion.get(i).getTipoEstado()==poblacion.get(i).getTipoEstado().menor) {
					this.poblacion.get(i).setAhorro(nv);
				}
			}
		} else {
			float reparto = (float) (dinero.getDineroTotal() / menores.size());
			for (int i = 0; i < this.poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado()==poblacion.get(i).getTipoEstado().menor) {
					this.poblacion.get(i).setAhorro(reparto);
				}
			}
		}
	}

	private int contarTipoPersona(EstadoSer estado, int contador) {
		for (int i = 0; i < this.poblacion.size(); i++) {
			if (estado == this.poblacion.get(i).getTipoEstado()) {
				contador++;
			}
		}
		return contador;
	}

	public void pagarDemandantes(DineroEstado dinero) {
		// Dinero que se le da a cada demandante y se acumula en el ahorro
		float nv = demandantes.getFirst().getTipoEstado().getNivelVida();
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(demandantes.getFirst().getTipoEstado(), contador);
		dineroTotalPagar = contador * nv / 2;
		if (dinero.getDineroTotal() >= dineroTotalPagar) {
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado()==poblacion.get(i).getTipoEstado().desempleado) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + dineroTotalPagar);
				}
			}
		} else {
			float reparto = (float) (dinero.getDineroTotal() / contador);
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado()==poblacion.get(i).getTipoEstado().desempleado) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + reparto);
				}
			}
		}
	}

	private float pedirAhorro(ArrayList<Seres> poblacion, int i) {
		return poblacion.get(i).getAhorro();
	}

	public void pagarJubilados(DineroEstado dinero) {
		// Dinero que se le da a cada jubilado y se acumula en el ahorro
		float nv = jubilados.get(0).getTipoEstado().getNivelVida();
		float dineroTotalPagar = 0;
		int contador = 0;
		contador = contarTipoPersona(jubilados.get(0).getTipoEstado(), contador);
		dineroTotalPagar = deberJubilados();
		if (dinero.getDineroTotal() >= dineroTotalPagar) {
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado()==poblacion.get(i).getTipoEstado().jubilado) {
					if (pedirAhorro(poblacion, i) < nv) {
						float pagar = nv - pedirAhorro(poblacion, i);
						poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + pagar);
					}
				}
			}
		} else {
			float reparto = (float) (dinero.getDineroTotal() / contarJubiladosMorosos());
			for (int i = 0; i < poblacion.size(); i++) {
				if (poblacion.get(i).getTipoEstado()==poblacion.get(i).getTipoEstado().jubilado && pedirAhorro(poblacion, i) < nv) {
					poblacion.get(i).setAhorro(pedirAhorro(poblacion, i) + reparto);
				}
			}
		}
	}

	public float deberJubilados() {
		int contador = 0;
		float nv = jubilados.get(0).getTipoEstado().getNivelVida();
		float acumulador = 0;
		contador = contarTipoPersona(jubilados.get(0).getTipoEstado(), contador);
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getTipoEstado()==poblacion.get(i).getTipoEstado().jubilado) {
				if (pedirAhorro(poblacion, i) < nv) {
					float diferencia = nv - pedirAhorro(poblacion, i);
					acumulador += diferencia;
				}
			}
		}
		return acumulador;

	}

	public int contarJubiladosMorosos() {
		float nv = jubilados.get(0).getTipoEstado().getNivelVida();
		int morosos = 0;
		for (int i = 0; i < poblacion.size(); i++) {
			if (poblacion.get(i).getTipoEstado()==poblacion.get(i).getTipoEstado().jubilado) {
				if (poblacion.get(i).getAhorro() < nv) {
					morosos++;
				}
			}
		}
		return morosos;
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

	public ArrayList<Seres> eliminarFallecidos() {
		fallecidos.clear();
		for (int i = 0; i < poblacion.size(); i++) {
			Seres persona = poblacion.get(i);
			if (isFallecido()) {
				fallecidos.add(persona);
				poblacion.remove(persona);
				if (jubilados.contains(persona)) {
					jubilados.remove(persona);
				}
			}
		}
		return fallecidos;
	}

	public void actualizarPoblacion() {
		int edad, respuesta;
		for (int i = 0; i < poblacion.size(); i++) {
			edad = poblacion.get(i).getEdad();
			respuesta = getRespuesta(edad);
			switch (respuesta) {
			case 0:
				poblacion.get(i).setTipoEstado(EstadoSer.menor);
				break;
			case 1:
				poblacion.get(i).setTipoEstado(EstadoSer.desempleado);
				break;
			case 2:
				poblacion.get(i).setTipoEstado(EstadoSer.jubilado);
			default:
				break;
			}

		}
		jubilarTrabajador();
		eliminarFallecidos();
		mayoresDeEdad();
		annadirMayoresEdad();
	}

	private int getRespuesta(int edad) {
		int valor;
		if (edad > 17 && edad < 65) {
			valor = 1;
		} else {
			if (edad < 17) {
				valor = 0;
			} else {
				valor = 2;
			}
		}
		return valor;
	}
}

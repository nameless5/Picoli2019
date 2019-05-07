package control;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.DineroEstado;
import modelo.empresa.Factorias;
import modelo.poblacion.EstadoSer;
import modelo.poblacion.Seres;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;

public class Estado {

	Factorias factoria;
	Poblacion poblacion;
	DineroEstado dinero;
	Sede sede;
	private double produccion = calcularProduccion();
	private double produccionAuxiliar = produccion;
	private double demanda;

	public Estado() {
		super();
		this.poblacion = new Poblacion(50, 100, 30);
		this.sede = new Sede();
		this.dinero = new DineroEstado(100000);
	}

	public void pasarPeriodo() {
		sede.produccionTotal();
		factoria.pagarTrabajador(dinero);
		poblacion.pagarNV(dinero);
		poblacion.envejecer();
		poblacion.cambiarTipoHabitante();
		poblacion.reducirVida();

	}

	public double getDemanda() {
		return demanda;
	}

	public double getProduccion() {
		return produccion;
	}

	public void setProduccion(double produccion) {
		this.produccion = produccion;
	}

	public float calcularProduccion() {
		int contarTrabajadores = poblacion.contarTipoPersona(EstadoSer.trabajador, 0);
		return contarTrabajadores * 1000;
	}

	public double incrementarDemanda() {
		float porcentaje = (float) (this.demanda * 0.1);
		return demanda += porcentaje;
	}

	public double disminuirDemanda() {
		float porcentaje = (float) (this.demanda * 0.1);
		return demanda -= porcentaje;
	}

	public int calcularTrabajadores() {
		double calcular = demanda - produccion;
		float diferencia = (float) (calcular / 1000);
		if (demanda != produccion) {
			if (demanda > produccion) {
				int trabajadores = (int) Math.ceil(diferencia);
				return trabajadores;
			} else {
				int trabajadores = (int) Math.ceil(diferencia);
				return trabajadores;
			}
		} else {
			return 0;
		}

	}

	public void contratarTrabajador(ArrayDeque<Seres> demandantes, Stack<Seres> pilaTrabajador) {
		// if(getDemanda()>factoria.getProduccion()) { /*Hay que obtener el numero
		// concreto de gente a emple*(
		Seres contratado = demandantes.poll();
		pilaTrabajador.push(contratado);
	}

	public void contratarOdespedir(ArrayDeque<Seres> demandantes, Stack<Seres> pilaTrabajador) {
		int trabajadores = calcularTrabajadores();
		if (trabajadores > 0) {
			if (demandantes.size() > trabajadores) {
				for (int i = 0; i < trabajadores; i++) {
					contratarTrabajador(demandantes, pilaTrabajador);
				}
			}else {
				int nacimientos = trabajadores-demandantes.size();
				for (int i = 0; i < demandantes.size(); i++) {
					contratarTrabajador(demandantes, pilaTrabajador);
				}
					poblacion.generadorCiudadanos(nacimientos);
			}

		} else {
			trabajadores = trabajadores * -1;
			for (int i = 0; i < trabajadores; i++) {
				sede.despedirTrabajadores(demandantes, factoria);
			}

		}
	}

	public void calcularDemandantes(double trabajadores, ArrayDeque<Seres> demandantes, Stack<Seres> pilaTrabajador) {
		if (demandantes.size() > trabajadores) {
			for (int i = 0; i < trabajadores; i++) {
				pilaTrabajador.push(demandantes.getFirst());

			}
		}

	}

	public void aumentarDemanda() {
		this.demanda = this.demanda + 10000;
	}

	public void decrementarDemanda() {
		this.demanda = this.demanda - 10000;
	}

	public DatosPoblacion getDatosPoblacion() {
		return new DatosPoblacion(this.poblacion.numeroPoblacion(), this.poblacion.numeroMenores(),
				this.sede.numTrabajadores(), this.poblacion.numeroJubilados(), 0, this.poblacion.numeroFallecidos(),
				this.poblacion.jubilarTrabajador().size(), 0);
	}

	public DatosEstadoGlobal getDatosEstadoGlobales() {
		return new DatosEstadoGlobal(this.demanda, this.sede.produccionTotal(), this.dinero.getDineroTotal(), 0);
	}

	public DatosEstadoLocal getDatosEstadoLocal() {
		return new DatosEstadoLocal(0, 0, 0, 0, 0, 0);
	}
}

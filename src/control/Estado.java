package control;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;

import modelo.empresa.DineroEstado;
import modelo.empresa.Factorias;
import modelo.poblacion.Seres;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;

public class Estado {

	private Factorias factoria;
	private Poblacion poblacion;
	private DineroEstado dinero;
	private Sede sede;

	private double demanda = 99999;

	public Estado() {
		super();
		this.poblacion = new Poblacion(50, 100, 30);
		this.sede = new Sede();
		this.dinero = new DineroEstado(100000);
	}

	public void pasarPeriodo() {
		this.poblacion.reducirVida();
		this.poblacion.envejecer();
		this.poblacion.actualizarPoblacion();
		this.sede.produccionTotal();
		this.poblacion.demandaAnual();
		this.sede.contratarDesempleados(this.poblacion.getDesempleados());
//		factoria.pagarTrabajador(dinero);
		this.poblacion.pagarNV(dinero);
	}

	public void aumentarDemanda() {
		this.demanda = this.demanda + 10000;
	}

	public void decrementarDemanda() {
		this.demanda = this.demanda - 10000;
	}

	public void jubilarTrabajador(Stack<Seres> pilaTrabajador, ArrayDeque<Seres> demandantes) {
		for (int i = 0; i < pilaTrabajador.size(); i++) {
			int edad = pilaTrabajador.get(i).getEdad();
			if (edad >= 65) {
				pilaTrabajador.remove(i);
			}
		}

		for (Iterator iterator = demandantes.iterator(); iterator.hasNext();) {
			Seres seres = (Seres) iterator.next();
			int edad = seres.getEdad();
			if (edad >= 65) {
				demandantes.remove(seres);
			}
		}
	}

	public DatosPoblacion getDatosPoblacion() {
		return new DatosPoblacion(this.poblacion.numeroPoblacion(), this.poblacion.numeroMenores(),
				this.sede.numTrabajadores(), this.poblacion.numeroJubilados(), 0,
				this.poblacion.eliminarFallecidos().size(), this.poblacion.jubilarTrabajador().size(), 0);
	}

	public DatosEstadoGlobal getDatosEstadoGlobales() {
		return new DatosEstadoGlobal(this.demanda, this.sede.produccionTotal(), this.dinero.getDineroTotal(), 0);
	}

	public DatosEstadoLocal getDatosEstadoLocal() {
		return new DatosEstadoLocal(0, 0, 0, 0, 0, 0);
	}

}

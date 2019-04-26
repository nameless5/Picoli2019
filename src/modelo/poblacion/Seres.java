package modelo.poblacion;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.LinkedList;

import control.Poblacion;

public class Seres implements EstablecerNV{
	private String nombre;
	private int edad;
	private float subsidio;
	private float ahorro;
	private float esperanzaVida;
	private float nivelVida;
	LinkedList<String> nombres = new LinkedList();
	private String[] personas= {"Antonio","Paco","Pepe","Monica","Laura","Marta","Manolo","Maria","Pedro","Jesus",
			"Fran","Ana","Raul","Victoria","SerRaro","Alien","Depredador","Pitufino","Rufino","Teresa"};
	
	public Seres() {
		super();
		nombre = generarNombreAleatorio(nombres);
		edad = generarEdad();
		this.subsidio = generarSubsidio();
		this.ahorro = generarAhorro();
		this.esperanzaVida = generarEsperanzaVida();
	}
	public String generarNombreAleatorio(LinkedList<String> nombres) {
		anadirNombresAlaLista(nombres);
		int min=1;
		int max=nombres.size();
		String aleatorio =nombres.get((int) (Math.random()*(max-min)+min));
		return aleatorio;
	}
	public int generarEdad() {
		edad=0;
		return (int) edad;
		
	}
	public int generarSubsidio() {
		subsidio=0;
		return (int) subsidio;
	};
	public int generarAhorro() {
		ahorro=0;
		return (int) ahorro;
	};
	public int generarEsperanzaVida() {
		int esperanzaVidaMin=0;
		int esperanzaVidaMax=90;
		int esperanzaVida = (int) (Math.random()*(esperanzaVidaMax-esperanzaVidaMin)+esperanzaVidaMin);
		return (int) esperanzaVida;
	}
	public void anadirNombresAlaLista(LinkedList<String> nombres) {
		for (int i = 0; i < personas.length; i++) {
			String nombresRecorridos=personas[i];
			nombres.add(nombresRecorridos);
		}
	}

	public LinkedList<String> getNombres() {
		return nombres;
	}

	public String[] getPersonas() {
		return personas;
	}

	public float getNivelVida() {
		return nivelVida;
	}

	public void setNivelVida(float nivelVida) {
		this.nivelVida = nivelVida;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSubsidio() {
		return subsidio;
	}

	public void setSubsidio(float subsidio) {
		this.subsidio = subsidio;
	}

	public float getAhorro() {
		return ahorro;
	}

	public void setAhorro(float ahorro) {
		this.ahorro = ahorro;
	}

	public float getEsperanzaVida() {
		return esperanzaVida;
	}

	public void setEsperanzaVida(float esperanzaVida) {
		this.esperanzaVida = esperanzaVida;
	}
	
	public float getNivelVida() {
		return nivelVida;
	}

	public void setNivelVida(float nivelVida) {
		this.nivelVida = nivelVida;
	}

	@Override
	public void establecerNV() {
		// TODO Auto-generated method stub
		
	}
}

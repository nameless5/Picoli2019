package modelo.poblacion;

import java.util.LinkedList;

public class Seres implements EstablecerNV{
	private String nombre;
	private int edad;
	private float subsidio;
	private float ahorro;
	private float esperanzaVida;
	private float nivelVida;
	LinkedList<String> nombres = new LinkedList();
	String[] personas= {"Antonio","Paco","Pepe","Monica","Laura","Marta","Manolo","Maria","Pedro","Jesus",
			"Fran","Ana","Raul","Victoria","SerRaro","Alien","Depredador","Pitufino","Rufino","Victoria"};
	
	
	public float getNivelVida() {
		return nivelVida;
	}

	public void setNivelVida(float nivelVida) {
		this.nivelVida = nivelVida;
	}

	public Seres(float subsidio, float ahorro) {
		super();
		nombre = generarNombreAleatorio(nombres);
		edad = generarEdad();
		this.subsidio = subsidio;
		this.ahorro = ahorro;
		this.esperanzaVida = generarEdad();

	}
	
	public int generarEdad() {
		int edadInicial=0;
		return edadInicial;
		
	}
	
	public void anadirNombresAlaLista(LinkedList<String> nombres) {
		for (int i = 0; i < personas.length; i++) {
			String nombresRecorridos=personas[i];
			nombres.add(nombresRecorridos);
		}
	}
	
	public String generarNombreAleatorio(LinkedList<String> nombres) {
		anadirNombresAlaLista(nombres);
		int min=1;
		int max=nombres.size();
		String aleatorio =nombres.get((int) (Math.random()*(max-min)+min));
		return aleatorio;
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

	@Override
	public void establecerNV() {
		// TODO Auto-generated method stub
		
	}
}

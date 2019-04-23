package control;

import modelo.poblacion.Cobrable;
import modelo.poblacion.Menor;
import modelo.poblacion.Seres;

import java.util.ArrayList;
import java.util.LinkedList;

import control.ListaPoblacion;

public class Estado  {
	float demanda;
	int numeroEmpresa;
	int numeroSeres;
	float cantidadMin;
	Seres seres;
	Menor menor;
	ListaPoblacion listas;
	public static void main(String[] args) {
		Estado estado = new Estado();
	
	}
	public int generarEdadMenorAleatoria() {
		int edadMax = 18;
		int edadMin=1;
		int edadAleatoria=(int) (Math.random()*(edadMax-edadMin)+edadMin);
		return edadAleatoria;
	}
	public String generarNombreAleatorio(LinkedList<String> nombres) {
		int min=1;
		int max=nombres.size();
		String aleatorio =nombres.get((int) (Math.random()*(max-min)+min));
		return aleatorio;
	}
	public void generadorCiudadanos(Menor menor,LinkedList<String> nombres) {
		Menor menorcito = new Menor(generarNombreAleatorio(nombres), generarEdadMenorAleatoria(), 150.f, 200.5f, 80, 0.2f, 12549632);
	}
	
	public void fallecimmiento() {
		//TODO
	}
	public void comprobarProduccion() {
		//TODO
	}
	public void comprobarPorcentajeTrabajadores() {
		//TODO
	}
	
	
}

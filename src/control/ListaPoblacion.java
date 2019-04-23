package control;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import modelo.poblacion.Jubilado;
import modelo.poblacion.Menor;
import modelo.poblacion.Seres;
import modelo.poblacion.Trabajador;

public class ListaPoblacion {
	String[] personas= {"Antonio","Paco","Pepe","Monica","Laura","Marta","Manolo","Maria","Pedro","Jesus",
			"Fran","Ana","Raul","Victoria","SerRaro","Alien","Depredador","Pitufino","Rufino","Victoria"};
	
	public static void main(String[] args) {
		ListaPoblacion listaPoblacion = new ListaPoblacion();
		ArrayList<Menor> menor = new ArrayList<>();
		ArrayList<Jubilado> jubilado = new ArrayList<>();
		ArrayList<Trabajador> trabajador = new ArrayList<>();
		LinkedList<String> nombres = new LinkedList();
		listaPoblacion.anadirNombresAlaLista(nombres);
	}
	
	public void anadirNombresAlaLista(LinkedList<String> nombres) {
		for (int i = 0; i < personas.length; i++) {
			String nombresRecorridos=personas[i];
			nombres.add(nombresRecorridos);
		}
	}
	
}

package control;

import modelo.poblacion.Cobrable;
import modelo.poblacion.Seres;

import java.util.ArrayList;
import java.util.LinkedList;


public class Estado  {
	
		
	float demanda;
	int numeroEmpresa;
	int numeroSeres;
	float cantidadMin;
 
	Seres yo = new Seres(3, 100);

	public boolean fallecimiento() {
		boolean resultado = false;
		if(yo.getNivelVida()>= yo.getEsperanzaVida()) {
			resultado = true;
			return resultado;
		}
		return resultado;
		
	}
	public void comprobarProduccion() {
		//TODO
	}
	public void comprobarPorcentajeTrabajadores() {
		//TODO
	}
	
	
}

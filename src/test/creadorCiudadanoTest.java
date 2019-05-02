package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import control.Poblacion;
import modelo.poblacion.Seres;

class creadorCiudadanoTest {
	Seres seres = new Seres();
	Poblacion poblacion = new Poblacion(0, 0, 0);
	ArrayList<Seres> menores;
	
	@Test
	void test() {
		boolean comprobador=false;
		if(seres.getEdad()==0 && seres.getAhorro()==0) {
			comprobador=true;
		} else comprobador =false;
		assertTrue(comprobador);
	}
	
}

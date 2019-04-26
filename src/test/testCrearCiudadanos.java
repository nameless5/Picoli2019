package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import control.Estado;
import control.Poblacion;
import junit.framework.Assert;
import modelo.poblacion.Seres;
class testCrearCiudadanos {
	Seres ser;
	Estado estadito;
	Poblacion poblacionn;
	ArrayList<Seres> menores;
	@Test
	void test() {
		Seres serecito = new Seres();
		String nombreDelSer=serecito.getNombre();
		menores.add(serecito);
	}
}

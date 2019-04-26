package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Estado;
import modelo.poblacion.Seres;

class EstadoTest {
	Estado estado = new Estado(0f, 0, 0);

	@Test
	void testFallecimiento() {
		Seres ser = new Seres();
		float edad = 2;
		float esperanzaVida = 3;

		if (edad >= esperanzaVida) {
			assertTrue(estado.fallecimiento(ser));
		} else {
			assertFalse(estado.fallecimiento(ser));
		}
	}

}

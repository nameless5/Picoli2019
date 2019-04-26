package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Estado;

class EstadoTest {
	Estado estado = new Estado();

	@Test
	void testFallecimiento() {
		float nivelVida = 2;
		float esperanzaVida = 3;
		
		if(nivelVida >= esperanzaVida) {
			assertTrue(estado.fallecimiento());
		}
		else {
			assertFalse(estado.fallecimiento());
		}
	}

}

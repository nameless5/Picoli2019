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
		if (ser.getEdad()>=ser.getEsperanzaVida()) {
			assertEquals(true, estado.fallecimiento(ser));
		} else {
			assertEquals(false, estado.fallecimiento(ser));
		}
	}

}

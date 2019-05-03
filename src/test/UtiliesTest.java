package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import utilesglobal.Utilies;

class UtiliesTest {

	@Test
	void testObtenerAleatorioInt() {
		new Utilies();
		int max=2;
		int min=0;
		boolean maxAlcanzado=false,minAlcanzado=false;
		for (int i = 0; i < 100; i++) {
			int obtenerAleatorio = Utilies.obtenerAleatorio(max);
			assertTrue(obtenerAleatorio<=max&&obtenerAleatorio>=min);
			if(obtenerAleatorio==max) {
				maxAlcanzado=true;
			}
			if(obtenerAleatorio==min) {
				minAlcanzado=true;
			}
		}
		assertTrue(minAlcanzado&&maxAlcanzado);
		
	}

	@Test
	void testObtenerAleatorioIntInt() {
		new Utilies();
		int max=2;
		int min=1;
		boolean maxAlcanzado=false,minAlcanzado=false;
		for (int i = 0; i < 100; i++) {
			int obtenerAleatorio = Utilies.obtenerAleatorio(min, max);
			assertTrue(obtenerAleatorio<=max&&obtenerAleatorio>=min);
			if(obtenerAleatorio==max) {
				maxAlcanzado=true;
			}
			if(obtenerAleatorio==min) {
				minAlcanzado=true;
			}
		}
		assertTrue(minAlcanzado&&maxAlcanzado);
	}

}

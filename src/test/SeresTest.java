package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import control.Estado;
import modelo.poblacion.Seres;

class SeresTest {
	
	Estado estado = new Estado(0, 0, 0);
	Seres ser = new Seres();
		
	@Test
	void testCalculaParteProporcional() {
		
		float necesidadVital = ser.getTipoEstado().getNivelVida();
		float entrada = estado.pagarTrabajador();
		float resultadoEsperado = ser.getTipoEstado().getNivelVida()/ entrada;
		
			if(necesidadVital > entrada) {
				assertEquals(resultadoEsperado ,ser.calcularParteProporcional(ser));	
		}
		
	}
	
	@Test
	void testReducirEsperanzaVida() {
		float esperanzaVida = ser.getEsperanzaVida();
		float resultadoEsperado = esperanzaVida - ser.calcularParteProporcional(ser); 
		
		assertEquals(resultadoEsperado, ser.reducirEsperanzaVida(ser));
		
	}
	
}

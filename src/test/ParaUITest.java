package test;

import org.junit.jupiter.api.Test;

import control.ParaUI;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;
import utilesglobal.Mensajes;

class ParaUITest {

	@Test
	void testRellenarComunicadorPoblacion() {
		DatosPoblacion datosPoblacion = new DatosPoblacion(1, 2, 3, 4, 5, 6, 7, 8);
		DatosEstadoLocal datosEstadoLocal = new DatosEstadoLocal(1, 2, 3, 4, 5, 6);
		DatosEstadoGlobal datosEstadoGlobal = new DatosEstadoGlobal(1, 2, 3, 4);
		ParaUI paraUI = new ParaUI();
		paraUI.setDatosEnElInterfazUsuario(datosPoblacion, datosEstadoLocal, datosEstadoGlobal);
		paraUI.setVisible(true);
		Mensajes.escribeEnConsola("para");
	}

}

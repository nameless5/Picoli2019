package control;

import modelo.vista.Datos;
import modelo.vista.DatosEstadoGlobal;
import modelo.vista.DatosEstadoLocal;
import modelo.vista.DatosPoblacion;
import vista.Comunicador;
import vista.UI;

public class ParaUI extends UI {

	public void setDatosEnElInterfazUsuario(DatosPoblacion datosPoblacion,DatosEstadoLocal datosEstadoLocal,DatosEstadoGlobal datosEstadoGlobal ) {
		rellenarComunicador(comunicadorPoblacion, datosPoblacion);
		rellenarComunicador(comunicadorEstadoLocal, datosEstadoLocal);
		rellenarComunicador(comunicadorEstadoGlobal, datosEstadoGlobal);
	}
	
	public void rellenarComunicador(Comunicador comunicador,Datos datos) {
		comunicador.asignarValores(datos);
	}
}

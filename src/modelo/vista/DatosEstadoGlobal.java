package modelo.vista;

import java.util.ArrayList;

public class DatosEstadoGlobal extends Datos {

	 public DatosEstadoGlobal(double demanda,double produccion,double capitalEstatal,double crecimientoAnual) {
		super();
		ArrayList datos = getDatos();
		datos.add(demanda);
		datos.add(produccion);
		datos.add(capitalEstatal);
		datos.add(crecimientoAnual);
	}
}

package modelo.vista;

import java.util.ArrayList;

public class DatosEstadoLocal extends Datos {

	public DatosEstadoLocal(int pequenas, float porcentajePequenas, int medianas,float porcentajeMedianastrabajadores, 
			int grandes, float porcentajeGrandes) {
		super();
		ArrayList datos = getDatos();
		datos.add(pequenas);
		datos.add(porcentajePequenas);
		datos.add(medianas);
		datos.add(porcentajeMedianastrabajadores);
		datos.add(grandes);
		datos.add(porcentajeGrandes);
	}
}

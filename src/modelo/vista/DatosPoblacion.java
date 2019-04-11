package modelo.vista;

import java.util.ArrayList;

public class DatosPoblacion extends Datos{
	
	public DatosPoblacion(long habitantes, long menores, long trabajadores, long jubilados, long nacimientos, long fallecimientos,
			long jubilaciones, long nuevosTrabajadores) {
		super();
		ArrayList<Long> datos = getDatos();
		datos.add(habitantes);
		datos.add(menores);
		datos.add(trabajadores);
		datos.add(jubilados);
		datos.add(nacimientos);
		datos.add(fallecimientos);
		datos.add(jubilaciones);
		datos.add(nuevosTrabajadores);
	}
	
}

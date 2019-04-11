package modelo.vista;

import java.util.ArrayList;

public abstract class Datos {
	//No me queda mas remedio que hacerla de tipo heterogeneo
	private ArrayList datos = new ArrayList();

	public ArrayList getDatos() {
		return datos;
	};

}

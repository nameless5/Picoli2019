package vista;

import java.util.ArrayList;

import javax.swing.JTextField;

import modelo.vista.Datos;

public class Comunicador {
	ArrayList<JTextField> jTextFields = new ArrayList<>();

	public boolean addControl(JTextField nuevo) {
		return jTextFields.add(nuevo);
	}

	public void asignarValores(Datos datos) {
		for (int i = 0; i < jTextFields.size(); i++) {
			jTextFields.get(i).setText(String.valueOf(datos.getDatos().get(i)));
		}
	}

}

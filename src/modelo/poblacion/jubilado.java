package modelo.poblacion;

public class jubilado extends seres{
	long id;
	public jubilado(String nombre, int edad, float subsidio, float ahorro, float esperanzaVida, float decrecimiento,long id) {
		super(nombre, edad, subsidio, ahorro, esperanzaVida, decrecimiento);
		this.id=id;
		// TODO Auto-generated constructor stub
	}

}

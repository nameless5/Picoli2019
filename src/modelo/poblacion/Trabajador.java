package modelo.poblacion;

public class Trabajador extends Seres{
	long id;
	public Trabajador(String nombre, int edad, float subsidio, float ahorro, float esperanzaVida, float decrecimiento,long id) {
		super(nombre, edad, subsidio, ahorro, esperanzaVida, decrecimiento);
		this.id=id;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void establecerNV() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cobrar() {
		// TODO Auto-generated method stub
		
	}
	
}

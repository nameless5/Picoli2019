package modelo.poblacion;

public abstract class Seres implements EstablecerNV, Cobrable{
	private String nombre;
	private int edad;
	private float subsidio;
	private float ahorro;
	private float esperanzaVida;
	private float decrecimiento;
	private  float nivelVida;
	
	public float getNivelVida() {
		return nivelVida;
	}

	public void setNivelVida(float nivelVida) {
		this.nivelVida = nivelVida;
	}

	public Seres(String nombre, int edad, float subsidio, float ahorro, float esperanzaVida, float decrecimiento) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.subsidio = subsidio;
		this.ahorro = ahorro;
		this.esperanzaVida = esperanzaVida;
		this.decrecimiento = decrecimiento;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSubsidio() {
		return subsidio;
	}

	public void setSubsidio(float subsidio) {
		this.subsidio = subsidio;
	}

	public float getAhorro() {
		return ahorro;
	}

	public void setAhorro(float ahorro) {
		this.ahorro = ahorro;
	}

	public float getEsperanzaVida() {
		return esperanzaVida;
	}

	public void setEsperanzaVida(float esperanzaVida) {
		this.esperanzaVida = esperanzaVida;
	}

	public float getDecrecimiento() {
		return decrecimiento;
	}

	public void setDecrecimiento(float decrecimiento) {
		this.decrecimiento = decrecimiento;
	}
}

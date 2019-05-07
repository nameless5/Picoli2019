package modelo.poblacion;

public enum EstadoSer {
	
	menor(365, 365, "menor"), desempleado(365, 182.5, "desempleado"), trabajador(365, 730, "trabajador"),
	jubilado(182.5f, 182.5, "jubilado");

	private float nivelVida;
	private double sueldo;
	private String estado;

	private EstadoSer(float nivelVida, double sueldo, String estado) {
		this.nivelVida = nivelVida;
		this.sueldo = sueldo;
		this.estado = estado;
	}

	public float getNivelVida() {
		return nivelVida;
	}

	public double getSueldo() {
		return sueldo;
	}

	public String getEstado() {
		return estado;
	}

}

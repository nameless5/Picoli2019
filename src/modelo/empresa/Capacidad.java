package modelo.empresa;

public enum Capacidad {
 grande (1000);
 private int valor;

private Capacidad(int valor) {
	this.valor = valor;
}

public int getValor() {
	return valor;
}

public void setValor(int valor) {
	this.valor = valor;
}
	
}

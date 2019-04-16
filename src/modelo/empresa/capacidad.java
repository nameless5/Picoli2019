package modelo.empresa;

public enum capacidad {
 pequeña/*(100)*/,mediana/*(400)*/, grande/*(100)*/;
 private int valor;

public int getValor() {
	return valor;
}

public void setValor(int valor) {
	this.valor = valor;
}
	
}

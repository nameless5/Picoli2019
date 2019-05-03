package utilesglobal;

import java.util.Random;

public class Utilies {

	public static int obtenerAleatorio(int max) {
		return new Random().nextInt(max+1);
	}
	public static int obtenerAleatorio(int min,int max) {
		return min+obtenerAleatorio(max-min);
	}
}

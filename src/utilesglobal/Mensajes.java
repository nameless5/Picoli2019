package utilesglobal;

public class Mensajes {
	private static boolean activados=true;
	
	public static void escribeEnConsola(String mensaje) {
		if(activados) {
			System.out.println(mensaje);
		}
	}
}

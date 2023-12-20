package graficos;

import java.awt.GraphicsEnvironment;

public class PruebaFuente {

	public static void main(String[] args) {
		
		String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); //Obtenemos las fuentes disponibles en la computadora
		
		for(String each: nombresDeFuentes) {
			
			System.out.println(each);
			
		}
		
	}

}

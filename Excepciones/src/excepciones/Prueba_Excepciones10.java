package excepciones;

import java.io.*;

public class Prueba_Excepciones10 {

	public static void main(String[] args) {
		
		try {
			
			Double.parseDouble("Hola");
			
			Integer.parseInt("Adi�s");
			
		} finally {
			
			System.out.println("Fin del programa");
			
		}
		
	}

}
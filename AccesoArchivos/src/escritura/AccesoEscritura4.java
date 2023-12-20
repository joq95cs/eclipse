package escritura;

import java.io.*;

public class AccesoEscritura4 {

	public static void main(String[] args) {
		
		try {
			
			Escritura.Escribir();
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	private static class Escritura {
		
		public static void Escribir() throws IOException {
			
			FileWriter fw = new FileWriter("c:/Users/joqle/Desktop/Prueba.txt");
			
			fw.append("Hola");
			
			fw.close();
			
		}
		
	}

}
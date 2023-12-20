package escritura;

import java.io.*;

public class AccesoEscritura {

	public static void main(String[] args) {
		
		new EscribirArchivo().escribir();

	}

}

class EscribirArchivo {
	
	public void escribir() {
		
		String cadena = "Esto es una prueba de escritura...";
		
		try {
			
			FileWriter escritura = new FileWriter("C:/Users/joqle/Desktop/ArchivoNuevo.txt");
		
			for(int i=0; i<cadena.length(); i++) {
				
				escritura.write(cadena.charAt(i));
				
				//escritura.write((int)cadena.charAt(i));
				
			}
			
			escritura.close();
			
		} catch (IOException e) {

		}
		
	}
	
}

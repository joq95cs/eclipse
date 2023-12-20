package lectura;

import java.io.*;

public class AccesoLectura {

	public static void main(String[] args) {
		
		new LeerArchivo().leer();

	}

}

class LeerArchivo {
	
	public void leer() {
		
		try {
			
			FileReader entrada = new FileReader("C:/Users/joqle/Documents/eclipseProjects/AccesoArchivos/src/lectura/ArchivoTexto.txt"); //Se abre un stream con un archivo de texto
			
			int c = entrada.read(); //Almacena el código del primer caracter
			
			while(c != -1) {
				
				char caracter = (char) c;
				
				System.out.print(caracter);
				
				c = entrada.read();
				
			}
			
			entrada.close(); //Un flujo de datos o Stream debe ser cerrado siempre
			
		} catch (IOException e) {
			
			System.out.println("No se ha encontrado el archivo...");
			
		}
		
	}
	
}

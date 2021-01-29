package streams_bytes;

import java.io.*;

public class Prueba {

	public static void main(String[] args) {
		
		leer();
		
		escribir(bytes);

	}
	
	public static void leer() {
		
		int contador = 0;
		
		bytes = new int[25189];
		
		try {
			
			FileInputStream lector = new FileInputStream("C:/Users/joqle/Desktop/scarlett.jpg");
			
			int byte_leido = lector.read();
			
			while(byte_leido != -1) {
				
				if(byte_leido != -1) {
					
					bytes[contador] = byte_leido;
					
					contador ++;
					
				}
				
				byte_leido = lector.read();
				
			}
			
			lector.close();
			
		} catch(IOException e) {
			
			System.err.println("Error " + e.getMessage());
			
		}
		
	}
	
	public static void escribir(int bytes[]) {
		
		try {
			
			FileOutputStream escritor = new FileOutputStream("C:/Users/joqle/Desktop/copia.jpg");
			
			for(int i=0; i<bytes.length; i++) {
				
				escritor.write(bytes[i]);
				
			}
			
			escritor.close();
			
		} catch(IOException e) {
			
			System.err.println("Error" + e.getMessage());
			
		}
		
	}
	
	private static int[] bytes;

}

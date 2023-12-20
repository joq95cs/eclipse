package lectura;

import java.io.*;

public class AccesoLectura3 {

	public static void main(String[] args) {
		
		try {
			
			Lectura.leer();
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	private static class Lectura {
		
		public static void leer() throws Exception {
			
			FileReader fr = new FileReader("src/lectura/ArchivoTexto.txt");
			
			BufferedReader br = new BufferedReader(fr);
			
			while(br.ready()) {
				
				System.out.println(br.readLine());
				
			}
			
			br.close();
			
			fr.close();
			
		}
		
	}

}

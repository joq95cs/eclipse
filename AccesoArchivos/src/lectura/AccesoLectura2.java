package lectura;

import java.io.*;

import javax.swing.JOptionPane;

public class AccesoLectura2 {

	public static void main(String[] args) {
		
		leer();

	}
	
	public static void leer() {
		
		try {
			
			File carpeta = new File("C:\\Users\\joqle\\Desktop\\PruebaEscritura");
			
			File archivo = new File(carpeta, "ArchivoEscritura.txt");
			
			FileReader fr = new FileReader(archivo);
			
			BufferedReader br = new BufferedReader(fr);
			
			String mensaje = "";
			
			String linea = br.readLine();
			
			while(linea != null) {
				
				mensaje += linea + "\n";
				
				linea = br.readLine();
				
			}
			
			JOptionPane.showMessageDialog(null, mensaje, "Mensaje leído", JOptionPane.INFORMATION_MESSAGE);
			
			br.close();
			
			fr.close();
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}
	
}
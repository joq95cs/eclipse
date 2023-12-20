package escritura;

import java.io.*;

import javax.swing.JOptionPane;

import java.util.*;

public class AccesoEscritura2 {

	public static void main(String[] args) {
		
		escribir();

	}
	
	public static void escribir() {
		
		try {
			
			File carpeta = new File("C:\\Users\\joqle\\Desktop\\PruebaEscritura\\");
			
			File archivo = new File(carpeta, "ArchivoEscritura.txt");
			
			if(!carpeta.exists()) {
				
				carpeta.mkdir();
				
			}
			
			if(!archivo.exists()) {
				
				archivo.createNewFile();
				
			}
			
			FileWriter fw = new FileWriter(archivo);
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese no. l�neas"));
			
			for(int i=0; i<n; i++) {
				
				bw.write(JOptionPane.showInputDialog("Ingrese l�nea no. " + (i+1)));
				
				if(i != n-1) {
					
					bw.newLine();
					
				}
				
			}
			
			bw.close();
			
			fw.close();
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

}
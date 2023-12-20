package streams_bytes;

import java.io.*;

import javax.swing.*;

import java.util.*;

public class Prueba_2 {

	public static void main(String[] args) {
		
		leer();
		
		escribir();

	}
	
	public static void leer() {
		
		try {
			
			FileInputStream lector = new FileInputStream("C:/Users/joqle/Desktop/imagen.jpg");
			
			int byte_leido = 0;
			
			while(byte_leido != -1) {
				
				byte_leido = lector.read();
				
				if(byte_leido != -1) {
					
					bytes.add(byte_leido);
					
				}
				
			}
			
			lector.close();
			
			System.out.println(bytes.size());
			
		} catch(IOException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
			
		}
		
	}
	
	public static void escribir() {
		
		try {
			
			FileOutputStream escritor = new FileOutputStream("C:/Users/joqle/Desktop/imagen_copia.jpg");
			
			for(int i=0; i<bytes.size(); i++) {
				
				escritor.write(bytes.get(i));
				
			}
			
			escritor.close();
			
		} catch(IOException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
			
		}
		
	}
	
	private static ArrayList<Integer> bytes = new ArrayList<Integer>();

}

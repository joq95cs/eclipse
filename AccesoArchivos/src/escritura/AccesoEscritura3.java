package escritura;

import java.io.*;

import javax.swing.*;

public class AccesoEscritura3 {

	public static void main(String[] args) {
		
		escribir();

	}
	
	public static void escribir() {
		
		try {
			
			FileWriter fw = new FileWriter("C:/Users/joqle/Desktop/ArchivoEscritura.txt");
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese no. de l�neas a escribir"));
			
			for(int i=0; i<n; i++) {
				
				bw.write(JOptionPane.showInputDialog("Ingrese l�nea no. " + (i+1)));
				
				if(i != n-1) {
					
					bw.newLine();
					
				}
				
			}
			
			bw.close();
			
			fw.close();
			
		} catch(IOException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error: " + e.getClass().getName(), JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

}

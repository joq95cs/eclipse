package excepciones;

import javax.swing.*;

public class Prueba_excepciones8 {

	public static void main(String[] args) {
		
		try {
			
			dividir();
			
		} catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Error de tipo: " + e.getClass().getName());
			
		} catch(NumberFormatException e) {
			
			System.out.println("Error de tipo: " + e.getClass().getName());
			
		}
		
	}
	
	public static void dividir() {
		
		double[] n = new double[2];
		
		for(int i=0; i<5; i++) {
			
			n[i] = Double.valueOf(JOptionPane.showInputDialog("Ingrese número " + (i+1) + ": "));
			
		}
		
		JOptionPane.showMessageDialog(null, "Resultado: " + n[0]/n[1]) ;
		
	}

}

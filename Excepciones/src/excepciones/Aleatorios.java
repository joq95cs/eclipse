package excepciones;

import javax.swing.JOptionPane;

public class Aleatorios {

	public static void main(String[] args) {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de elementos"));
		
		int[] aleatorios = new int[n];
		
		for(int i=0; i<aleatorios.length; i++) {
			
			aleatorios[i] = (int)(Math.random()*100);
			
		}
		
		for(int e: aleatorios) {
			
			System.out.println(e);
			
		}

	}

}

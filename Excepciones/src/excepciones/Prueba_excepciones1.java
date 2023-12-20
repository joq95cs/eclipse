package excepciones;

import javax.swing.*;

public class Prueba_excepciones1 {

	public static void main(String[] args) {
		
		try {
			
			Prueba_excepciones1.setDatos();
			
			Prueba_excepciones1.getDatos();
			
		} catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
			
		}

	}
	
	public static void setDatos() throws NumberFormatException {
		
		nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
		
		edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu edad"));
		
	}
	
	public static void getDatos() {
		
		JOptionPane.showMessageDialog(null, "Hola " + nombre + ", en 10 años tendrás " + (edad+10) + " años de edad...");
		
	}
	
	private static String nombre;
	
	private static int edad;

}

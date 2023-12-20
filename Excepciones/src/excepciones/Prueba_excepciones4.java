package excepciones;

import javax.swing.*;

public class Prueba_excepciones4 {

	public static void main(String[] args) {
		
		validarMayoriaEdad();

	}
	
	public static void validarMayoriaEdad() throws RuntimeException {
		
		String nombre = JOptionPane.showInputDialog("Ingrese nombre");
		
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
		
		if(edad < 18 && edad > 0) {
			
			throw new RuntimeException("La persona es menor de edad");
			
		} else if(edad < 1) {
			
			throw new RuntimeException("Edad no válida");
			
		} else {
			
			JOptionPane.showMessageDialog(null, nombre + " es mayor de edad...");
			
		}
		
	}

}

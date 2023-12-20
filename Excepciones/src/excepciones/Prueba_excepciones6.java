package excepciones;

import javax.swing.JOptionPane;

public class Prueba_excepciones6 {

	public static void main(String[] args) {
		
		try {
			
			validarMayoriaEdad();
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			
			e.printStackTrace();
			
		}

	}
	
	public static void validarMayoriaEdad() throws Exception {
		
		String nombre = JOptionPane.showInputDialog("Ingrese nombre");
		
		int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
		
		if(edad < 18 && edad > 0) {
			
			throw new Exception ("La persona es menor de edad");
			
		} else if(edad < 1) {
			
			throw new Exception ("Edad no válida");
			
		} else {
			
			JOptionPane.showMessageDialog(null, nombre + " es mayor de edad...");
			
		}
		
	}

}

package excepciones;

import javax.swing.*;

public class Prueba_excepciones3 {

	public static void main(String[] args) {
		
		try {
			
			decirNombre();
			
		} catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			
		}

	}
	
	public static void decirNombre() throws Exception {
		
		String nombre = JOptionPane.showInputDialog("Ingrese nombre");
		
		if(nombre.length() < 3) {
			
			throw new Exception("El nombre es muy corto"); //Mensaje de error
			
		} else {
			
			JOptionPane.showMessageDialog(null, "El nombre " + nombre + " es correcto");
			
		}
		
	}

}

import javax.swing.*;

public class Entrada_ejemplo2 {

	public static void main(String[] args) {
		
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre por favor");
		
		String edad = JOptionPane.showInputDialog("Introduce tu edad por favor");
		
		System.out.println("Hola " + nombre + " tienes " + edad + " años...");
			
		int edad1 = Integer.parseInt(edad);
		
		edad1++;
		
		System.out.println("Hola " + nombre + " el proximo año tendrás " + edad1 + " años...");
	}

}

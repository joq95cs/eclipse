import javax.swing.*;
public class Factorial {

	public static void main(String[] args) {
		
		long resultado = 1L, i, 
			numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce numero"));
		
		for(i=numero; i>0; i--) {
			
			resultado = resultado * i;
			
		}

		System.out.println("El factorial del número es " + numero + " es: " + resultado);
	}

}

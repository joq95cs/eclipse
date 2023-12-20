import java.util.*;

import javax.swing.*;

public class Areas {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("1. Cuadrado\n2. Rect�ngulo\n3. Tri�ngulo\n4. C�rculo\n\nElige una opci�n: ");

		byte figura = entrada.nextByte();
		
		switch(figura) {
		
		case 1:
			
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce lado"));
			
			System.out.println("El �rea del cuadrado es: " + Math.pow(lado, 2));
			
			break;
			
		case 2:
			
			int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce base"));
			
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura"));
			
			System.out.println("El �rea del rect�ngulo es: " + base*altura);
			
			break;
			
		case 3:
			
			base = Integer.parseInt(JOptionPane.showInputDialog("Introduce base"));
			
			altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce altura"));
			
			System.out.println("El �rea del tri�ngulo es: " + (base * altura) / 2);
			
			break;
			
		case 4:
			
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce radio"));
			
			System.out.print("El �rea del c�rculo es: ");
			
			System.out.printf("%1.2f", Math.PI * Math.pow(radio, 2));
			
			break;
			
		default:
			
			System.out.printf("La opci�n no es correcta...");
		}
		
		entrada.close();
	}

}

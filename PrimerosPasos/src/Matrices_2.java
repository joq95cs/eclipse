import javax.swing.*;
public class Matrices_2 {

	public static void main(String[] args) {
		
		String paises[] = new String[8];
		
		/*paises[0] = "M�xico";
		paises[1] = "Egipto";
		paises[2] = "China";
		paises[3] = "Jap�n";
		paises[4] = "Reino Unido";
		paises[5] = "Nueva Zelanda";
		paises[6] = "Estados Unidos";
		paises[7] = "Francia";*/
		
		/*for(int i=0; i<paises.length; i++) {
			
			System.out.println("Pa�s " + (i+1) + ": " + paises[i]);
		}*/
		
		for(int i=0; i<paises.length; i++) {
			
			paises[i] = JOptionPane.showInputDialog("Introduce pa�s " + (i+1));
		}
		
		int x = 1;
		
		for(String elemento:paises) {
			
			System.out.println("Pa�s " + x + ": " + elemento);
			
			x++;
			
		}
	}

}

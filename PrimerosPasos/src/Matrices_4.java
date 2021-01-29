import javax.swing.JOptionPane;

public class Matrices_4 {

	public static void main(String[] args) {
		
		String matriz_nombres[] = new String[5];
		
		for(int i=0; i<matriz_nombres.length; i++) {
			
			matriz_nombres[i] = JOptionPane.showInputDialog("Introduce nombre " + (i+1));
			
		}
		
		int j = 1;
		
		for(String nombre: matriz_nombres) {
			
			System.out.println(j + ": " + nombre);
			
			j++;
			
		}

	}

}

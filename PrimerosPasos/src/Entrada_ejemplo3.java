import javax.swing.JOptionPane;

public class Entrada_ejemplo3 {

	public static void main(String[] args) {
		
		String cantante = JOptionPane.showInputDialog("Ingrese el nombre del cantante");
		
		String genero = JOptionPane.showInputDialog("Ingrese el g�nero que canta");
		
		String cancion = JOptionPane.showInputDialog("Ingrese el nombre de una de sus canciones");
		
		System.out.println("La canci�n " + cancion + " pertenece al cantante de " + genero + " " + cantante + "...");
		
	}

}

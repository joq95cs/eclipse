package graficos;

import java.awt.*;

import javax.swing.*;

public class PruebaFuente_2 {

	public static void main(String[] args) {
		
		String fuente = JOptionPane.showInputDialog("Escribe nombre de fuente a buscar");
		
		boolean fuente_disponible = false;
		
		String[] mis_fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for(String each: mis_fuentes) {
			
			if(each.equalsIgnoreCase(fuente)) {
				
				fuente_disponible = true;
				
			}
			
		}
		
		if(fuente_disponible) {
			
			System.out.println("FUENTE INSTALADA");
			
		}
		
		else {
			
			System.out.println("FUENTE NO INSTALADA");
			
		}

	}

}

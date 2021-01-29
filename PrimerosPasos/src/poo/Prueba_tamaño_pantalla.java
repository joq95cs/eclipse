package poo;

import java.awt.*;

import javax.swing.*;

public class Prueba_tamaño_pantalla {

	public static void main(String[] args) {
		
		DimeTamaño pantalla = new DimeTamaño();
		
		pantalla.muestraTamaño();

	}

}

class DimeTamaño extends JFrame {
	
	public DimeTamaño() {
		
		this.mi_pantalla = Toolkit.getDefaultToolkit();
		
		this.tamaño = mi_pantalla.getScreenSize();
		
	}
	
	public void muestraTamaño() {
		
		System.out.println("Ancho: " + tamaño.width + " píxeles\nAlto: " + tamaño.height + " píxeles");
		
	}
	
	private Toolkit mi_pantalla;
	
	private Dimension tamaño;
	
}

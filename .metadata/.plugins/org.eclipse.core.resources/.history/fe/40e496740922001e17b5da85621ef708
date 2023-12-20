package poo;

import java.awt.*;

import javax.swing.*;

public class Prueba_tamagno_pantalla {

	public static void main(String[] args) {
		
		DimeTamagno pantalla = new DimeTamagno();
		
		pantalla.muestraTamagno();

	}

}

class DimeTamagno extends JFrame {
	
	public DimeTamagno() {
		
		this.mi_pantalla = Toolkit.getDefaultToolkit();
		
		this.tamagno = mi_pantalla.getScreenSize();
		
	}
	
	public void muestraTamagno() {
		
		System.out.println("Ancho: " + tamagno.width + " p�xeles\nAlto: " + tamagno.height + " p�xeles");
		
	}
	
	private Toolkit mi_pantalla;
	
	private Dimension tamagno;
	
}

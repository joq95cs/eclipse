package poo;

import java.awt.*;

import javax.swing.*;

public class Prueba_tama�o_pantalla {

	public static void main(String[] args) {
		
		DimeTama�o pantalla = new DimeTama�o();
		
		pantalla.muestraTama�o();

	}

}

class DimeTama�o extends JFrame {
	
	public DimeTama�o() {
		
		this.mi_pantalla = Toolkit.getDefaultToolkit();
		
		this.tama�o = mi_pantalla.getScreenSize();
		
	}
	
	public void muestraTama�o() {
		
		System.out.println("Ancho: " + tama�o.width + " p�xeles\nAlto: " + tama�o.height + " p�xeles");
		
	}
	
	private Toolkit mi_pantalla;
	
	private Dimension tama�o;
	
}

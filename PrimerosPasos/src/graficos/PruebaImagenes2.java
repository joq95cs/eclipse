package graficos;

import javax.imageio.*; //Contiene la clase ImageIO

import java.awt.*; //Contiene la clase Image

import java.io.*; //Contiene la clase File

import java.net.*; //Contiene la clase URL

import javax.swing.*;

public class PruebaImagenes2 {

	public static void main(String[] args) {
		
		MarcoImagenes2 marco = new MarcoImagenes2();
		
		marco.setVisible(true);

	}

}

class MarcoImagenes2 extends JFrame {
	
	public MarcoImagenes2() {
		
		setSize(600, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LaminaImagenes2());
		
	}
	
}

class LaminaImagenes2 extends JPanel {
	
	public LaminaImagenes2() {
		
		try {
			
			imagen = ImageIO.read(new URL("http://orig07.deviantart.net/7188/f/2016/053/7/0/civil_war_s_scarlet_witch___transparent__by_camo_flauge-d9ssw0o.png"));
			
		} catch(IOException e) {
			
			System.out.println("No se encuentra la imagen...");
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.drawImage(imagen, 0, 0, null);
		
	}
	
	private Image imagen;
	
}

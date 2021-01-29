package graficos;

import javax.swing.*;

import java.awt.*;

import javax.imageio.*;

import java.io.*;

public class PruebaImagenes {

	public static void main(String[] args) {
		
		MarcoConImagenes miMarco = new MarcoConImagenes();
		
		miMarco.setVisible(true);
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConImagenes extends JFrame {
	
	public MarcoConImagenes() {
		
		this.setBounds(0, 0, 300, 200);
		
		this.setTitle("Marco con imagenes");
		
		LaminaConImagenes miLamina = new LaminaConImagenes();
		
		this.add(miLamina);
		
	}
	
}

class LaminaConImagenes extends JPanel {
	
	public LaminaConImagenes() {
		
		try { //Tratamiento de excepciones
			
			miImagen = ImageIO.read(new File("src/graficos/goku.jpg"));
			
		} catch(IOException e) {
			
			System.out.println("NO SE ENUENTRA LA IMAGEN");
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//File miArchivo = new File("src/graficos/goku.jpg");
		
		int anchoImagen = miImagen.getWidth(this);
		
		int altoImagen = miImagen.getHeight(this);
		
		g.drawImage(miImagen, 0, 0, null);

		for(int i=0; i<300; i++) {
			
			for(int j=0; j<200; j++) {
				
				if(i+j > 0) {
					
					g.copyArea(0, 0, anchoImagen, altoImagen, i*anchoImagen, j*altoImagen);
					
				}
				
			}
			
		}
		
	}
	
	private Image miImagen;
	
}

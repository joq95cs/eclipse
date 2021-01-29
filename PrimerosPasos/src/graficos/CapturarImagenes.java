package graficos;

import java.awt.*; //Contiene la clase Image

import javax.imageio.*; //Contiene la clase ImageIO

import java.io.*; //Contiene la clase File

import javax.swing.*; //Contiene la clase ImageIcon

import java.net.*; //Contiene la clase URL

public class CapturarImagenes {

	public static void main(String[] args) {
		
		Image imagen1 = Toolkit.getDefaultToolkit().getImage("src/graficos/bulma.jpg");
		
		Image imagen2 = Toolkit.getDefaultToolkit().createImage("src/graficos/bulma.jpg");
		
		try {
			
			Image imagen3 = ImageIO.read(new File("src/graficos/goku.jpg"));
			
		} catch(IOException e) {
			
			System.out.println("Imagen no encontrada");
			
		}
		
		try {

			Image imagen5 = ImageIO.read(new URL("https://fsmedia.imgix.net/2f/a0/e7/9e/1579/4e5d/b0ec/9cccfa85b258/marvel-black-widow-winter-soldier-movie.jpeg"));
			
		} catch(IOException e) {
			
			System.out.println("Imagen no encontrada");
			
		}
		
		ImageIcon icono = new ImageIcon("src/graficos/reloj.gif"); 

	}

}

package graficos;

import java.awt.Toolkit;

import java.awt.*;

import javax.swing.*;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {

		MarcoCentrado miMarco = new MarcoCentrado();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);
		
	}

}

class MarcoCentrado extends JFrame {
	
	public MarcoCentrado() {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit(); //Almacena dentro de la variable objeto el sistema nativo de ventanas.
		
		Dimension tamanoPantalla = miPantalla.getScreenSize(); //Almacena dentro de la variable objeto el tamaño de la pantalla.
		
		int altoPantalla = tamanoPantalla.height;
		
		int anchoPantalla = tamanoPantalla.width;
		
		this.setSize(anchoPantalla/2, altoPantalla/2);
		
		this.setLocation(anchoPantalla/4, altoPantalla/4);
		
		this.setTitle("MARCO CENTRADO");
		
		Image miIcono = miPantalla.getImage("src/graficos/icono.gif"); //Se pone la ruta a partir de la raíz. La raíz es el nombre del proyecto.
		
		this.setIconImage(miIcono);
		
	}
	
}
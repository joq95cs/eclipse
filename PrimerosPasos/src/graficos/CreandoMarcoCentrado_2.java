package graficos;

import java.awt.*;

import javax.swing.*;

public class CreandoMarcoCentrado_2 {

	public static void main(String[] args) {
		
		MarcoCentrado_2 marco = new MarcoCentrado_2();

	}

}

class MarcoCentrado_2 extends JFrame {
	
	public MarcoCentrado_2() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = pantalla.getScreenSize();
		
		int alto = tamagno.height;
		
		int ancho = tamagno.width;
		
		this.setSize((ancho/4), (alto/4));
		
		this.setLocation(3*ancho/8, 3*alto/8);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("JOQSAN ADALID");
		
		Image icono = pantalla.getImage("src/graficos/icono.gif");
		
		this.setIconImage(icono);
		
		this.setResizable(false);
		
		this.setVisible(true);
		
	}
	
}

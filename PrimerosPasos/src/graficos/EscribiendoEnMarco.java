package graficos;

import javax.swing.*;

import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		
		MarcoConTexto marco = new MarcoConTexto();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConTexto extends JFrame {
	
	public MarcoConTexto() {
		
		this.setVisible(true);
		
		this.setSize(600, 400);
		
		this.setLocation(400, 200);
		
		this.setTitle("Primer texto");
		
		Lamina lamina = new Lamina();
		
		this.add(lamina);
		
	}
	
}

class Lamina extends JPanel { //JPanel es la clase para crear láminas o páneles (capas)
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g); //Llama al método original
		
		g.drawString("Estamos aprendiendo Swing", 100, 100); //Indica lo que va a hacer además de su trabajo original
		
	}
	
}

package graficos;

import javax.swing.*;

import java.awt.*;

public class VentanaBotones {

	public static void main(String[] args) {
		
		MarcoConBotones marco = new MarcoConBotones();

	}

}

class MarcoConBotones extends JFrame {
	
	public MarcoConBotones() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = pantalla.getScreenSize();
		
		int ancho = tamagno.width, alto = tamagno.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		setTitle("Marco con botones");
		
		LaminaConBotones lamina = new LaminaConBotones();
		
		add(lamina);
		
	}
	
}

class LaminaConBotones extends JPanel {
	
	public LaminaConBotones() {
		
		add(boton);
		
	}
	
	JButton boton = new JButton("Bot�n");
	
}

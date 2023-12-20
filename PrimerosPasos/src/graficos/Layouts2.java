package graficos;

import javax.swing.*;

import java.awt.*;

public class Layouts2 {

	public static void main(String[] args) {
		
		MarcoLayouts2 marco = new MarcoLayouts2();

	}

}

class MarcoLayouts2 extends JFrame {
	
	public MarcoLayouts2() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Layouts");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		LaminaLayouts2 lamina = new LaminaLayouts2();
		
		LaminaLayouts3 lamina2 = new LaminaLayouts3();
		
		add(lamina, BorderLayout.SOUTH);
		
		add(lamina2, BorderLayout.NORTH);
		
	}
	
}

class LaminaLayouts2 extends JPanel {
	
	public LaminaLayouts2() {
		
		setLayout(new BorderLayout());
		
		add(new JButton("Bot�n 1"), BorderLayout.EAST);
		
		add(new JButton("Bot�n 2"), BorderLayout.WEST);
		
		add(new JButton("Bot�n 3"), BorderLayout . CENTER);
		
	}
	
}

class LaminaLayouts3 extends JPanel {
	
	public LaminaLayouts3() {
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		add(new JButton("Bot�n 4"));
		
		add(new JButton("Bot�n 5"));
		
		add(new JButton("Bot�n 6"));
		
	}
	
}

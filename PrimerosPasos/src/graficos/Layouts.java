package graficos;

import java.awt.*;

import javax.swing.*;

public class Layouts {

	public static void main(String[] args) {
		
		MarcoLayouts marco = new MarcoLayouts();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoLayouts extends JFrame {
	
	public MarcoLayouts() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Layouts");
		
		//FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
		
		LaminaLayout lamina = new LaminaLayout();
		
		//lamina.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		LaminaLayout2 lamina2 = new LaminaLayout2();
		
		add(lamina, BorderLayout.NORTH);
		
		add(lamina2, BorderLayout.SOUTH);
		
	}
	
}

class LaminaLayout extends JPanel {
	
	public LaminaLayout() {
		
		//setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JButton("Amarillo"));
		
		add(new JButton("Verde"));
		
	}
	
}

class LaminaLayout2 extends JPanel {
	
	public LaminaLayout2() {
		
		setLayout(new BorderLayout());
		
		add(new JButton("Azúl"), BorderLayout.EAST);
		
		add(new JButton("Negro"), BorderLayout.WEST);
		
		add(new JButton("Rosa"));
		
	}
	
}
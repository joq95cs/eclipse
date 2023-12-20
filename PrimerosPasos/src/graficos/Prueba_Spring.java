package graficos;

import java.awt.*;

import javax.swing.*;

public class Prueba_Spring {
	
	public static void main(String[] args) {
		
		new MarcoSpring().setVisible(true);
		
	}
	
}

class MarcoSpring extends JFrame {
	
	public MarcoSpring() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Prueba Spring");
		
		int wm = 1000, hm = 350;
		
		int ws = Toolkit.getDefaultToolkit().getScreenSize().width, 
			hs = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ws/2-wm/2, hs/2-hm/2, wm, hm);
		
		add(new LaminaSpring());
		
	}
	
}

class LaminaSpring extends JPanel {
	
	public LaminaSpring() {
		
		JButton boton1 = new JButton("Botón 1");
		
		JButton boton2 = new JButton("Botón 2");
		
		JButton boton3 = new JButton("Botón 3");
		
		SpringLayout layout = new SpringLayout();
		
		setLayout(layout); //Pertenece a Swing
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		Spring muelle = Spring.constant(0, 10, 100); //Mímino, preferido y máximo
		
		//Colocación del muelle en las partes necesarias
		
		layout.putConstraint(SpringLayout.WEST, boton1, muelle, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.WEST, boton2, muelle, SpringLayout.EAST, boton1);
		
		layout.putConstraint(SpringLayout.WEST, boton3, muelle, SpringLayout.EAST, boton2);
		
		layout.putConstraint(SpringLayout.EAST, this, muelle, SpringLayout.EAST, boton3);
		
	}
	
}
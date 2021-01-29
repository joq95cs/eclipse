package graficos;

import java.awt.*;

import javax.swing.*;

public class Prueba_Spring2 {
	
	public static void main(String[] args) {
		
		new MarcoSpring2().setVisible(true);
		
	}
	
}

class MarcoSpring2 extends JFrame {
	
	public MarcoSpring2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Prueba Spring");
		
		int wm = 1000, hm = 350;
		
		int ws = Toolkit.getDefaultToolkit().getScreenSize().width, 
			hs = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ws/2-wm/2, hs/2-hm/2, wm, hm);
		
		add(new LaminaSpring2());
		
	}
	
}

class LaminaSpring2 extends JPanel {
	
	public LaminaSpring2() {
		
		JButton boton1 = new JButton("Botón 1");
		
		JButton boton2 = new JButton("Botón 2");
		
		JButton boton3 = new JButton("Botón 3");
		
		SpringLayout layout = new SpringLayout();
		
		setLayout(layout); //Pertenece a Swing
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		Spring muelle1 = Spring.constant(100, 10, 100); //Muelle no rígido
		
		Spring muelle2 = Spring.constant(50); //Muelle rígido
		
		//Colocación de los muelles en las partes necesarias
		
		layout.putConstraint(SpringLayout.WEST, boton1, muelle1, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.WEST, boton2, muelle2, SpringLayout.EAST, boton1);
		
		layout.putConstraint(SpringLayout.WEST, boton3, muelle2, SpringLayout.EAST, boton2);
		
		layout.putConstraint(SpringLayout.EAST, this, muelle1, SpringLayout.EAST, boton3);
		
	}
	
}
package graficos;

import java.awt.*;

import javax.swing.*;

public class Layouts3 {

	public static void main(String[] args) {
		
		MarcoLayouts3 marco = new MarcoLayouts3();

	}

}

class MarcoLayouts3 extends JFrame {
	
	public MarcoLayouts3() {
		
		setLayout(new FlowLayout());
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Layouts");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		JButton boton1 = new JButton("Botón 1");
		
		JButton boton2 = new JButton("Botón 2");
		
		JButton boton3 = new JButton("Botón 3");
		
		JButton boton4 = new JButton("Botón 4");
		
		JButton boton5 = new JButton("Botón 5");
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		add(boton4);
		
		add(boton5);
		
	}
	
}

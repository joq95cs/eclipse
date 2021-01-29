package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class PruebaBotonesRadio {

	public static void main(String[] args) {
		
		MarcoBotonesRadio marco = new MarcoBotonesRadio();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoBotonesRadio extends JFrame {
	
	public MarcoBotonesRadio() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setSize(ancho/3, alto/3);
		
		setLocation(ancho/3, alto/3);
		
		setTitle("Botones de radio");
		
		LaminaBotonesRadio lamina = new LaminaBotonesRadio();
		
		add(lamina);
		
	}
	
}

class LaminaBotonesRadio extends JPanel {
	
	public LaminaBotonesRadio() {
		
		ButtonGroup grupo1 = new ButtonGroup();
		
		ButtonGroup grupo2 = new ButtonGroup();
		
		JRadioButton boton1 = new JRadioButton("Azúl", false);
		
		JRadioButton boton2 = new JRadioButton("Rosa", true);
	
		JRadioButton boton3 = new JRadioButton("Verde", false);
		
		JRadioButton boton4 = new JRadioButton("Mujer", false);
		
		JRadioButton boton5 = new JRadioButton("Hombre", false);
		
		grupo1.add(boton1);
		
		grupo1.add(boton2);
		
		grupo1.add(boton3);
		
		grupo2.add(boton4);
		
		grupo2.add(boton5);
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		add(boton4);
		
		add(boton5);
		
	}
	
}

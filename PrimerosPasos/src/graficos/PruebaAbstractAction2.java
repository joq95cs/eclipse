package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class PruebaAbstractAction2 {

	public static void main(String[] args) {
		
		MarcoAbstractAction2 marco = new MarcoAbstractAction2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoAbstractAction2 extends JFrame {
	
	public MarcoAbstractAction2() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width;
		
		int alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setResizable(false);
		
		setTitle("Hola mundo");
		
		LaminaAbstractAction2 lamina = new LaminaAbstractAction2();
		
		add(lamina);
		
	}
	
}

class LaminaAbstractAction2 extends JPanel {
	
	public LaminaAbstractAction2() {
		
		AccionAbstractAction2 accion1 = new AccionAbstractAction2("Lanza mensaje");
		
		AccionAbstractAction2 accion2 = new AccionAbstractAction2("Termina el programa");
		
		JButton boton1 = new JButton(accion1);
		
		JButton boton2 = new JButton(accion2);
		
		add(boton1);
		
		add(boton2);
		
	}
	
}

class AccionAbstractAction2 extends AbstractAction {
	
	public AccionAbstractAction2(String nombre) {
		
		putValue(Action.NAME, nombre);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String boton_presionado = (String)getValue(Action.NAME);
		
		if(boton_presionado.equals("Lanza mensaje")) {
			
			System.out.println("HOLA A TODOS!!!");
			
		}
		
		else {
			
			System.exit(0);
			
		}
		
	}
	
}
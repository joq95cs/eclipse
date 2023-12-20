package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class CuadrosDialogo {

	public static void main(String[] args) {
		
		new MarcoCD().setVisible(true);

	}

}

class MarcoCD extends JFrame {
	
	public MarcoCD() {
		
		setSize(400, 250);
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setLocation(ancho/2-getWidth()/2, alto/2-getHeight()/2);
		
		setTitle("Cuadros de diálogo");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LaminaCD());
		
	}
	
}

class LaminaCD extends JPanel {
	
	public LaminaCD() {
		
		boton1 = new JButton("Botón 1");
		
		boton2 = new JButton("Botón 2");
		
		boton3 = new JButton("Botón 3");
		
		boton4 = new JButton("Botón 4");
		
		Oyente o = new Oyente();
		
		boton1.addActionListener(o);
		
		boton2.addActionListener(o);
		
		boton3.addActionListener(o);
		
		boton4.addActionListener(o);
		
		add(boton1);
		
		add(boton2);
		
		add(boton3);
		
		add(boton4);
		
	}
	
	private JButton boton1, boton2, boton3, boton4;
	
	private class Oyente implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(boton1)) {
				
				JOptionPane.showMessageDialog(LaminaCD.this, "Hola");
				
			} else if(e.getSource().equals(boton2)) {
				
				JOptionPane.showInputDialog(LaminaCD.this, "Ingresa tu nombre");
				
			} else if(e.getSource().equals(boton3)) {
				
				JOptionPane.showConfirmDialog(LaminaCD.this, "Elije opción", "Ventana Confirmación", 0);
				
			} else {
				
				JOptionPane.showOptionDialog(LaminaCD.this, "Elije", "Ventana Opciones", 1, 1, null, null, null);
				
			}
			
		}
		
	}
	
}
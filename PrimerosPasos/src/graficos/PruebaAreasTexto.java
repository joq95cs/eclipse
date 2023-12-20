package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaAreasTexto {

	public static void main(String[] args) {
		
		MarcoAT marco = new MarcoAT();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoAT extends JFrame {
	
	public MarcoAT() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Prueba area de texto");
		
		LaminaAT lamina = new LaminaAT();
		
		add(lamina);
		
	}
	
}

class LaminaAT extends JPanel {
	
	public LaminaAT() {
		
		area = new JTextArea(8, 20);
		
		JScrollPane lamina_scroll = new JScrollPane(area);
		
		area.setLineWrap(true); //Cuando se llega a llenar el renglón hace un salto de línea
		
		add(lamina_scroll);
		
		JButton boton = new JButton("Haz clic");
		
		OyenteAT oyente = new OyenteAT();
		
		boton.addActionListener(oyente);
		
		add(boton);
		
	}
	
	private class OyenteAT implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(area.getText());
			
		}
		
	}
	
	private JTextArea area;
	
}

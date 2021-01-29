package graficos;

import javax.swing.*;

import java.awt.*;

import javax.swing.event.*;

import javax.swing.text.*;

public class EventosTexto {

	public static void main(String[] args) {
		
		MarcoET marco = new MarcoET();

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
		
	}

}

class MarcoET extends JFrame {
	
	public MarcoET() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Eventos texto");
		
		LaminaET lamina = new LaminaET();
		
		add(lamina);
		
	}
	
}

class LaminaET extends JPanel {
	
	public LaminaET() {
		
		JTextField campo = new JTextField(30);
		
		Document documento = campo.getDocument();
		
		OyenteET oyente = new OyenteET();
		
		documento.addDocumentListener(oyente);
		
		add(campo);
		
	}
	
	private class OyenteET implements DocumentListener {

		public void changedUpdate(DocumentEvent arg0) { //Cuando el texto cambia sus propiedades
			
		}
		
		public void insertUpdate(DocumentEvent arg0) {
			
			System.out.println("Has introducido texto");
			
		}

		public void removeUpdate(DocumentEvent arg0) {
			
			System.out.println("Has borrado texto");
			
		}
		
	}
	
}

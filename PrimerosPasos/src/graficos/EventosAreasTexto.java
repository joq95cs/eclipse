package graficos;

import javax.swing.*;

import java.awt.*;

import javax.swing.event.*;

import javax.swing.text.*;

public class EventosAreasTexto {

	public static void main(String[] args) {
		
		MarcoEAT marco = new MarcoEAT();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEAT extends JFrame {
	
	public MarcoEAT() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Eventos areas de texto");
		
		setResizable(false);
		
		LaminaEAT lamina = new LaminaEAT();
		
		add(lamina);
		
	}
	
}

class LaminaEAT extends JPanel {
	
	public LaminaEAT() {
		
		JTextArea area = new JTextArea(8, 20);
		
		area.setLineWrap(true);
		
		JScrollPane lamina_scroll = new JScrollPane(area);
		
		add(lamina_scroll);
		
		Document documento;
		
		documento = area.getDocument();
		
		DocumentListener oyente = new OyenteEAT();
		
		documento.addDocumentListener(oyente);
		
	}
	
}

class OyenteEAT implements DocumentListener {
	
	public void changedUpdate(DocumentEvent arg0) {
		
	}

	public void insertUpdate(DocumentEvent arg0) {

		System.out.println("Has insertado texto");
		
	}

	public void removeUpdate(DocumentEvent arg0) {
		
		System.out.println("Has removido texto");

	}
	
}

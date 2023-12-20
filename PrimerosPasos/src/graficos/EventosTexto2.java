package graficos;

import java.awt.*;

import javax.swing.*;

import javax.swing.event.*;

public class EventosTexto2 {

	public static void main(String[] args) {
		
		MarcoET2 marco = new MarcoET2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoET2 extends JFrame {
	
	public MarcoET2() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Validar contrase�a");
		
		LaminaET2 lamina = new LaminaET2();
		
		add(lamina);
		
	}
	
}

class LaminaET2 extends JPanel {
	
	public LaminaET2() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina_aux = new JPanel();
		
		lamina_aux.setLayout(new GridLayout(2, 2));
		
		add(lamina_aux, BorderLayout.NORTH);
		
		JLabel etiqueta_1 = new JLabel("Usuario: ");
		
		JLabel etiqueta_2 = new JLabel("Contrase�a: ");
		
		JTextField campo_1 = new JTextField(15);
		
		campo_2 = new JPasswordField(15);
		
		DocumentListener oyente = new OyenteET2();
		
		campo_2.getDocument().addDocumentListener(oyente);
		
		lamina_aux.add(etiqueta_1);
		
		lamina_aux.add(campo_1);
		
		lamina_aux.add(etiqueta_2);
		
		lamina_aux.add(campo_2);
		
		JButton boton = new JButton("Enviar");
		
		add(boton, BorderLayout.SOUTH);
		
	}
	
	private class OyenteET2 implements DocumentListener {

		public void changedUpdate(DocumentEvent e) {
			
		}
		
		public void insertUpdate(DocumentEvent e) {
			
			char[] contrasegna = campo_2.getPassword();
			
			if(contrasegna.length < 8 || contrasegna.length > 12) {
				
				campo_2.setBackground(Color.RED);
				
			}
			
			else {
				
				campo_2.setBackground(Color.WHITE);
				
			}
			
		}

		public void removeUpdate(DocumentEvent e) {
			
			char[] contrasegna = campo_2.getPassword();
			
			if(contrasegna.length < 8 || contrasegna.length > 12) {
				
				campo_2.setBackground(Color.RED);
				
			}
			
			else {
				
				campo_2.setBackground(Color.WHITE);
				
			}
			
		}
		
	}
	
	private JPasswordField campo_2;
	
}
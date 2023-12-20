package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaTexto {

	public static void main(String[] args) {
		
		MarcoTexto marco = new MarcoTexto();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoTexto extends JFrame {
	
	public MarcoTexto() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Evaluar Email");
		
		LaminaTexto lamina = new LaminaTexto();
		
		add(lamina);
		
	}
	
}

class LaminaTexto extends JPanel {
	
	public LaminaTexto() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina2 = new JPanel();
		
		lamina2.setLayout(new FlowLayout());
		
		resultado = new JLabel("", JLabel.CENTER);
		
		JLabel etiqueta1 = new JLabel("Email: ");
		
		lamina2.add(etiqueta1);
		
		campo1 = new JTextField(20);
		
		lamina2.add(campo1);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton boton = new JButton("Comprobar");
		
		OyenteTexto oyente = new OyenteTexto();
		
		boton.addActionListener(oyente);
		
		lamina2.add(boton);
		
		add(lamina2, BorderLayout.NORTH);
		
	}
	
	private class OyenteTexto implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			int no_arrobas = 0;
			
			int no_puntos = 0;
			
			String email = campo1.getText().trim();
			
			for(int i=0; i<email.length(); i++) {
				
				if(email.charAt(i) == '@') {
					
					no_arrobas += 1;
					
				}
				
			}
			
			for(int i=0; i<email.length(); i++) {
				
				if(email.charAt(i) == '.') {
					
					no_puntos += 1;
					
				}
				
			}
			
			if(no_arrobas > 1 || no_puntos == 0) {
				
				resultado.setText("Incorrecto");
				
			}
			
			else {
				
				resultado.setText("Correcto");
				
			}
			
		}
		
	}
	
	private JTextField campo1;
	
	private JLabel resultado;
	
}


package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class ComprobarEmail {
	
	public static void main(String[] args) {
		
		MarcoEmail marco = new MarcoEmail();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
		
	}
	
}

class MarcoEmail extends JFrame {
	
	public MarcoEmail() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Comprobación de Email");
		
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().createImage("src/graficos/email.gif"));
		
		LaminaEmail1 lamina1 = new LaminaEmail1();
		
		add(lamina1);
		
	}
	
}

class LaminaEmail1 extends JPanel {
	
	public LaminaEmail1() {
		
		setLayout(new BorderLayout());
		
		LaminaEmail2 lamina2 = new LaminaEmail2();
		
		etiqueta2 = new JLabel("", JLabel.CENTER);
		
		add(lamina2, BorderLayout.NORTH);
		
		add(etiqueta2, BorderLayout.CENTER);
		
	}
	
	private class LaminaEmail2 extends JPanel {
		
		public LaminaEmail2() {
			
			setLayout(new FlowLayout());
			
			JLabel etiqueta1 = new JLabel("Email: ");
			
			campo = new JTextField("", 15);
			
			JButton boton = new JButton("Comprobar");
			
			OyenteEmail oyente = new OyenteEmail();
			
			boton.addActionListener(oyente);
			
			add(etiqueta1);
			
			add(campo);
			
			add(boton);
			
		}
		
		private class OyenteEmail implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
				
				String email = campo.getText().trim();
				
				int no_arrobas = 0;
				
				int no_puntos = 0;
				
				char caracter_inicial = email.charAt(0);
				
				char caracter_final = email.charAt(email.length()-1);
		
				boolean tiene_mayusculas = false;
				
				boolean tiene_espacios = false;
				
				String aux1 = null;
				
				String aux2 = null;
				
				for(int i=0; i<email.length(); i++) {
					
					if(email.charAt(i) == '@') {
						
						no_arrobas ++;
						
					}
					
				}
				
				for(int i=0; i<email.length(); i++) {
					
					if(email.charAt(i) == '.') {
						
						no_puntos ++;
						
					}
					
				}
				
				for(int i=0; i<email.length(); i++) {
					
					if(email.charAt(i) == ' ') {
						
						tiene_espacios = true;
						
					}
					
				}
				
				for(int i=0; i<email.length(); i++) {
					
					if(email.charAt(i) == '@') {
						
					}
					
					else if(email.charAt(i) == '.') {
						
					}
					
					else if(email.charAt(i) == ' ') {
						
					}
					
					else if(email.charAt(i) == '_') {
						
					}
					
					else if(email.charAt(i) == '-') {
						
					}
					
					else if(email.charAt(i) == '0') {
						
					}
					
					else if(email.charAt(i) == '1') {
						
					}
					
					else if(email.charAt(i) == '2') {
						
					}
					
					else if(email.charAt(i) == '3') {
						
					}
					
					else if(email.charAt(i) == '4') {
						
					}
					
					else if(email.charAt(i) == '5') {
						
					}
					
					else if(email.charAt(i) == '6') {
						
					}
					
					else if(email.charAt(i) == '7') {
						
					}
					
					else if(email.charAt(i) == '8') {
						
					}
					
					else if(email.charAt(i) == '9') {
						
					}
					
					else {
						
						aux1 = "" + email.charAt(i);
						
						aux2 = aux1.toUpperCase();
						
						if(aux1.equals(aux2)) {
							
							tiene_mayusculas = true;
							
						}
						
					}
					
				}
				
				if(no_arrobas>1 || no_puntos==0 || caracter_inicial == '@' || caracter_inicial == '.' || caracter_final == '@' || caracter_final == '.' || tiene_espacios == true || tiene_mayusculas == true) {
					
					etiqueta2.setText("EMAIL INCORRECTO");
					
					Toolkit.getDefaultToolkit().beep();
					
				}
				
				else {
					
					etiqueta2.setText("EMAIL CORRECTO");
					
					Toolkit.getDefaultToolkit().beep();
					
				}
				
			}
			
		}
		
		private JTextField campo;
		
	}
	
	private JLabel etiqueta2;
	
}
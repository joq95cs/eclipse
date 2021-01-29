package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaEventosFoco2 {

	public static void main(String[] args) {
		
		MarcoEventosFoco2 marco = new MarcoEventosFoco2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosFoco2 extends JFrame {
	
	public MarcoEventosFoco2() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Prueba eventos de foco 2");
		
		setResizable(false);
		
		LaminaEventosFoco2 lamina = new LaminaEventosFoco2();
		
		add(lamina);
		
	}
	
}

class LaminaEventosFoco2 extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		setLayout(null);
		
		cuadro1 = new JTextField();
		
		cuadro2 = new JTextField();
		
		cuadro1.setBounds(50, 50, 150, 20);
		
		cuadro2.setBounds(50, 100, 150, 20);
		
		OyenteEventosFoco2 oyente = new OyenteEventosFoco2();
		
		cuadro1.addFocusListener(oyente);
		
		add(cuadro1);
		
		add(cuadro2);
		
	}
	
	JTextField cuadro1;
	
	JTextField cuadro2;
	
	private class OyenteEventosFoco2 implements FocusListener {
		
		public void focusLost(FocusEvent e) {
			
			String email = cuadro1.getText();
			
			boolean comprobacion = false;
			
			for(int i=0; i<email.length(); i++) {
				
				if(email.charAt(i) == '@') {
					
					comprobacion = true;
					
				}
				
			}
			
			if(comprobacion) {
				
				System.out.println("El email es correcto");
				
			}
			
			else {
				
				System.out.println("El email no es correcto");
				
			}
			
		}
		
		public void focusGained(FocusEvent e) {
			
			
			
		}
		
	}
	
}

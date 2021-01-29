package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaEventosFoco3 extends JFrame implements WindowFocusListener {

	public static void main(String[] args) {
		
		PruebaEventosFoco3 objeto = new PruebaEventosFoco3();
		
		objeto.iniciar();
		
	}
	
	public void windowGainedFocus(WindowEvent e) {
		
		if(e.getSource() == marco1) {
			
			marco1.setTitle("Tengo el foco");
			
		}
		
		else {
			
			marco2.setTitle("Tengo el foco");
			
		}
		
	}
	
	public void windowLostFocus(WindowEvent e) {
		
		if(e.getSource() == marco1) {
			
			marco1.setTitle(null);
			
		}
		
		else {
			
			marco2.setTitle(null);
			
		}
		
	}
	
	public void iniciar() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		marco1 = new PruebaEventosFoco3();
		
		marco2 = new PruebaEventosFoco3();
		
		marco1.setBounds(ancho/4, 3*alto/8, ancho/4, alto/4);
		
		marco2.setBounds(2*ancho/4, 3*alto/8, ancho/4, alto/4);
		
		marco1.setResizable(false);
		
		marco2.setResizable(false);
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco1.setVisible(true);
		
		marco2.setVisible(true);
		
		marco1.addWindowFocusListener(this);
		
		marco2.addWindowFocusListener(this);
		
	}

	PruebaEventosFoco3 marco1;
	
	PruebaEventosFoco3 marco2;

}


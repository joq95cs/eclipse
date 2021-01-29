package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaAbstractAction {

	public static void main(String[] args) {
		
		MarcoPruebaAbstractAction marco = new MarcoPruebaAbstractAction();

	}

}

class MarcoPruebaAbstractAction extends JFrame {
	
	public MarcoPruebaAbstractAction() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setTitle("Prueba Abstract Action");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		setVisible(true);
		
		add(new LaminaPruebaAbstractAction());
		
	}
	
}

class LaminaPruebaAbstractAction extends JPanel {
	
	public LaminaPruebaAbstractAction() {
		
		add(new JButton(new AccionPruebaAbstractAction("Sonido")));
		
	}
	
}

class AccionPruebaAbstractAction extends AbstractAction {
	
	public AccionPruebaAbstractAction(String nombre) {
		
		putValue(Action.NAME, nombre);
		
		putValue(Action.SHORT_DESCRIPTION, "Suena un beep");
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}
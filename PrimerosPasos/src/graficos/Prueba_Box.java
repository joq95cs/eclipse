package graficos;

import javax.swing.*;

import java.awt.*;

public class Prueba_Box {

	public static void main(String[] args) {
		
		new MarcoBox().setVisible(true);

	}

}

class MarcoBox extends JFrame {
	
	public MarcoBox() {
		
		setLayout(new GridLayout());
		
		setTitle("Prueba Box");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(w/3, h/3, w/3, h/3);
		
		add(new LaminaBox());
		
	}
	
}

class LaminaBox extends JPanel {
	
	public LaminaBox() {
		
		setLayout(new GridLayout());
		
		JLabel et1 = new JLabel("Nombre");
		
		JTextField ct1 = new JTextField(10);
		
		ct1.setMaximumSize(ct1.getPreferredSize());
		
		Box ch1 = Box.createHorizontalBox();
		
		ch1.add(et1);
		
		ch1.add(Box.createHorizontalStrut(10));
		
		ch1.add(ct1);
		
		JLabel et2 = new JLabel("Contraseña");
		
		JTextField ct2 = new JTextField(10);
		
		ct2.setMaximumSize(ct2.getPreferredSize());
		
		Box ch2 = Box.createHorizontalBox();
		
		ch2.add(et2);
		
		ch2.add(Box.createHorizontalStrut(10));
		
		ch2.add(ct2);
		
		JButton bt1 = new JButton("Aceptar");
		
		JButton bt2 = new JButton("Cancelar");
		
		Box ch3 = Box.createHorizontalBox();
		
		ch3.add(bt1);
		
		ch3.add(Box.createGlue()); //Adapta el espacio entre los dos botones
		
		ch3.add(bt2);
		
		Box cv = Box.createVerticalBox();
		
		cv.add(ch1);
		
		cv.add(Box.createGlue());
		
		cv.add(ch2);
		
		cv.add(Box.createGlue());
		
		cv.add(ch3);
		
		add(cv);
		
	}
	
}
package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaCheckBox {

	public static void main(String[] args) {
		
		MarcoCheckBox marco = new MarcoCheckBox();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoCheckBox extends JFrame {
	
	public MarcoCheckBox() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setSize(ancho/4, alto/4);
		
		setLocation(3*ancho/8, 3*alto/8);
		
		setTitle("Check box");
		
		LaminaCheckBox lamina = new LaminaCheckBox();
		
		add(lamina);
		
	}
	
}

class LaminaCheckBox extends JPanel {
	
	public LaminaCheckBox() {
		
		setLayout(new BorderLayout());
		
		Font letra = new Font("Serif", Font.PLAIN, 24);
		
		texto = new JLabel("Let the rain fall down...");
		
		texto.setFont(letra);
		
		JPanel laminaTexto = new JPanel();
		
		laminaTexto.add(texto);
		
		add(laminaTexto, BorderLayout.CENTER);
		
		check1 = new JCheckBox("Negrita");
		
		check2 = new JCheckBox("Cursiva");
		
		check1.addActionListener(new OyenteCheckBox());
		
		check2.addActionListener(new OyenteCheckBox());
		
		JPanel laminaChecks = new JPanel();
		
		laminaChecks.add(check1);
		
		laminaChecks.add(check2);
		
		add(laminaChecks, BorderLayout.SOUTH);
		
	}
	
	private class OyenteCheckBox implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			int tipo = 0;
			
			if(check1.isSelected()) tipo += Font.BOLD;
			
			if(check2.isSelected()) tipo += Font.ITALIC;
			
			texto.setFont(new Font("Serif", tipo, 24));
			
		}
		
	}
	
	private JLabel texto;
	
	private JCheckBox check1, check2;

}
	

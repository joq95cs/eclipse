package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class PruebaComboBox {

	public static void main(String[] args) {
		
		MarcoComboBox marco = new MarcoComboBox();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		marco.setVisible(true);
		
	}

}

class MarcoComboBox extends JFrame {
	
	public MarcoComboBox() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;  
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;  
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("ComboBox");
		
		LaminaComboBox lamina = new LaminaComboBox();
		
		add(lamina);
		
	}
	
}

class LaminaComboBox extends JPanel {

	public LaminaComboBox() {
		
		setLayout(new BorderLayout());
		
		texto = new JLabel("Let the rain fall down and wake my dreams...", JLabel.CENTER);
		
		texto.setFont(new Font("Serif", Font.PLAIN, 16));
		
		add(texto, BorderLayout.CENTER);
		
		JPanel laminaNorte = new JPanel();
		
		combo = new JComboBox();
		
		combo.setEditable(true);
		
		combo.addItem("Comic Sans MS");
		
		combo.addItem("Sans");
		
		combo.addItem("Monospaced");
		
		combo.addItem("Dialog");
		
		OyenteComboBox oyente = new OyenteComboBox();
		
		combo.addActionListener(oyente);
		
		laminaNorte.add(combo);
		
		add(laminaNorte, BorderLayout.NORTH);
		
	}
	
	private class OyenteComboBox implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			texto.setFont(new Font(combo.getSelectedItem().toString(), Font.PLAIN, 20));
			
		}
		
	}
	
	private JLabel texto;
	
	private JComboBox combo;
}
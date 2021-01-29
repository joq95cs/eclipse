package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaComboBox2 {

	public static void main(String[] args) {
		
		MarcoComboBox2 marco = new MarcoComboBox2();
		
		marco.setVisible(true);

	}

}

class MarcoComboBox2 extends JFrame {
	
	public MarcoComboBox2() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Combo Box");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaComboBox2 lamina = new LaminaComboBox2();
		
		add(lamina);
		
	}
	
}

class LaminaComboBox2 extends JPanel {
	
	public LaminaComboBox2() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina_combo = new JPanel();
		
		JPanel lamina_color = new JPanel();
		
		lamina_color.setBackground(Color.white);
		
		JComboBox combo = new JComboBox();
		
		combo.addItem(Color.red);
		
		combo.addItem(Color.green);
		
		combo.addItem(Color.blue);
		
		combo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lamina_color.setBackground((Color)combo.getSelectedItem());
				
			}
			
		} );
		
		lamina_combo.add(combo);
		
		add(lamina_combo, BorderLayout.NORTH);
		
		add(lamina_color, BorderLayout.CENTER);
		
	}
	
}
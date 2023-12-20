package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class PruebaComboBox3 {

	public static void main(String[] args) {
		
		MarcoComboBox3 marco = new MarcoComboBox3();
		
		marco.setVisible(true);

	}

}

class MarcoComboBox3 extends JFrame {
	
	public MarcoComboBox3() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Combo Box Colores");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaComboBox3 lamina = new LaminaComboBox3();
		
		add(lamina);
		
	}
	
}

class LaminaComboBox3 extends JPanel {
	
	public LaminaComboBox3() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina_norte = new JPanel();
		
		JPanel lamina_centro = new JPanel();
		
		JComboBox combo = new JComboBox();
		
		combo.addItem("Blanco");
		
		combo.addItem("Rosa");
		
		combo.addItem("Amarillo");
		
		combo.addItem("Negro");
		
		combo.addItem("Naranja");
		
		combo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(combo.getSelectedItem() == "Blanco") lamina_centro.setBackground(Color.white);
				
				if(combo.getSelectedItem() == "Rosa") lamina_centro.setBackground(Color.pink);
				
				if(combo.getSelectedItem() == "Amarillo") lamina_centro.setBackground(Color.yellow);
				
				if(combo.getSelectedItem() == "Negro") lamina_centro.setBackground(Color.black);
				
				if(combo.getSelectedItem() == "Naranja") lamina_centro.setBackground(Color.orange);
				
			}
			
		});
		
		lamina_norte.add(combo);
		
		lamina_centro.setBackground(Color.white);
		
		add(lamina_centro, BorderLayout.CENTER);
		
		add(lamina_norte, BorderLayout.NORTH);
		
	}
	
}
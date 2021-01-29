package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class ComboBoxRGB {

	public static void main(String[] args) {
		
		MarcoComboBoxRGB marco = new MarcoComboBoxRGB();
		
		marco.setVisible(true);

	}

}

class MarcoComboBoxRGB extends JFrame {
	
	public MarcoComboBoxRGB() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Combo Box RGB");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaComboBoxRGB lamina = new LaminaComboBoxRGB();
		
		add(lamina);
		
	}
	
}

class LaminaComboBoxRGB extends JPanel {
	
	public LaminaComboBoxRGB() {
		
		setLayout(new BorderLayout());
		
		combo = new JComboBox();
		
		combo.setEditable(true);
		
		combo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lamina_color.setBackground(new Color(Integer.parseInt(combo.getSelectedItem().toString())));
				
			}
			
		});
		
		add(combo, BorderLayout.NORTH);
		
		lamina_color = new JPanel();
		
		lamina_color.setBackground(Color.white);
		
		add(lamina_color, BorderLayout.CENTER);
		
	}
	
	private JComboBox combo;
	
	private JPanel lamina_color;
	
}

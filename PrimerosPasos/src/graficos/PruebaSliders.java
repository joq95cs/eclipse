package graficos;

import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

public class PruebaSliders {

	public static void main(String[] args) {
		
		MarcoSliders marco = new MarcoSliders();
		
		marco.setVisible(true);

	}

}

class MarcoSliders extends JFrame {
	
	public MarcoSliders() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Sliders");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaSliders lamina = new LaminaSliders();
		
		add(lamina);
		
	}
	
}

class LaminaSliders extends JPanel {
	
	public LaminaSliders() {
		
		JSlider slider = new JSlider(0, 200, 100);
		
		slider.setMajorTickSpacing(50);
		
		slider.setMinorTickSpacing(25);
		
		slider.setPaintTicks(true);
		
		slider.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		slider.setPaintLabels(true);
		
		slider.setSnapToTicks(true);
		
		add(slider);
		
	}
	
}


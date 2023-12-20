package graficos;

import java.awt.*;

import javax.swing.*;

import javax.swing.event.*;

public class SliderRGB {

	public static void main(String[] args) {
		
		MarcoSliderRGB marco = new MarcoSliderRGB();
		
		marco.setVisible(true);
		
	}

}

class MarcoSliderRGB extends JFrame {
	
	public MarcoSliderRGB() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Slider RGB");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaSliderRGB lamina = new LaminaSliderRGB();
		
		add(lamina);
		
	}
	
}

class LaminaSliderRGB extends JPanel {
	
	public LaminaSliderRGB() {
		
		setLayout(new BorderLayout());
		
		OyenteSliderRGB oyente = new OyenteSliderRGB();
		
		control_rojo = new JSlider(JSlider.VERTICAL, 0, 255, 0);
		
		control_rojo.addChangeListener(oyente);
		
		add(control_rojo, BorderLayout.WEST);
		
		control_verde = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		
		control_verde.addChangeListener(oyente);
		
		add(control_verde, BorderLayout.SOUTH);
		
		control_azul = new JSlider(JSlider.VERTICAL, 0, 255, 0);
		
		control_azul.addChangeListener(oyente);
		
		add(control_azul, BorderLayout.EAST);
		
		lamina_color = new JPanel();
		
		lamina_color.setBackground(new Color(0, 0, 0));
		
		add(lamina_color, BorderLayout.CENTER);

		
	}
	
	private class OyenteSliderRGB implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			
			lamina_color.setBackground(new Color(control_rojo.getValue(), control_verde.getValue(), control_azul.getValue()));
			
		}
		
	}
	
	private JSlider control_rojo;
	
	private JSlider control_verde;
	
	private JSlider control_azul;
	
	private JPanel lamina_color;
	
}

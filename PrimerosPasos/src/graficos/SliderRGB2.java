package graficos;

import javax.swing.*;

import java.awt.*;

import javax.swing.event.*;

public class SliderRGB2 {

	public static void main(String[] args) {
		
		MarcoSliderRGB2 marco = new MarcoSliderRGB2();
		
		marco.setVisible(true);

	}

}

class MarcoSliderRGB2 extends JFrame {
	
	public MarcoSliderRGB2() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Slider RGB 2");
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaSliderRGB2 lamina = new LaminaSliderRGB2();
		
		add(lamina);
		
	}
	
}

class LaminaSliderRGB2 extends JPanel {
	
	public LaminaSliderRGB2() {
		
		setLayout(new BorderLayout());
		
		OyenteSliderRGB2 oyente = new OyenteSliderRGB2();
		
		slider_rojo = new JSlider(SwingConstants.VERTICAL, 0, 255, 255);
		
		slider_rojo.addChangeListener(oyente);
		
		slider_verde = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 255);
		
		slider_verde.addChangeListener(oyente);
		
		slider_azul = new JSlider(SwingConstants.VERTICAL, 0, 255, 255);
		
		slider_azul.addChangeListener(oyente);
		
		add(slider_rojo, BorderLayout.WEST);
		
		add(slider_verde, BorderLayout.SOUTH);
		
		add(slider_azul, BorderLayout.EAST);
		
		lamina_rgb = new JPanel();
		
		lamina_rgb.setLayout(new GridLayout());
		
		lamina_rojo = new JPanel();
		
		lamina_rojo.setBackground(new Color(255, 0, 0));
		
		lamina_rgb.add(lamina_rojo);
		
		lamina_verde = new JPanel();
		
		lamina_verde.setBackground(new Color(0, 255, 0));
		
		lamina_rgb.add(lamina_verde);
		
		lamina_azul = new JPanel();
		
		lamina_azul.setBackground(new Color(0, 0, 255));
		
		lamina_rgb.add(lamina_azul);
		
		lamina_mezcla = new JPanel();
		
		lamina_mezcla.setBackground(new Color(255, 255, 255));
		
		lamina_rgb.add(lamina_mezcla);
		
		add(lamina_rgb, BorderLayout.CENTER);
		
	}
	
	private class OyenteSliderRGB2 implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			
			lamina_rojo.setBackground(new Color(slider_rojo.getValue(), 0, 0));
			
			lamina_verde.setBackground(new Color(0, slider_verde.getValue(), 0));
			
			lamina_azul.setBackground(new Color(0, 0, slider_azul.getValue()));
			
			lamina_mezcla.setBackground(new Color(slider_rojo.getValue(), slider_verde.getValue(), slider_azul.getValue()));
			
		}
		
	}
	
	private JPanel lamina_rojo;
	
	private JPanel lamina_verde;
	
	private JPanel lamina_azul;
	
	private JPanel lamina_mezcla;
	
	private JPanel lamina_rgb;
	
	private JSlider slider_rojo;
	
	private JSlider slider_verde;
	
	private JSlider slider_azul;
	
}
package graficos;

import javax.swing.*;

import java.awt.*;

import javax.swing.event.*;

public class SliderColor {

	public static void main(String[] args) {
		
		MarcoSliderColor marco = new MarcoSliderColor();
		
		marco.setVisible(true);

	}

}

class MarcoSliderColor extends JFrame {
	
	public MarcoSliderColor() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Slider Color");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaSliderColor lamina = new LaminaSliderColor();
		
		add(lamina);
		
	}
	
}

class LaminaSliderColor extends JPanel {
	
	public LaminaSliderColor() {
		
		setLayout(new BorderLayout());
		
		slider = new JSlider(0, 16777215, 0);
		
		slider.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
				lamina_color.setBackground(new Color(slider.getValue()));
				
			}
			
		});
		
		add(slider, BorderLayout.NORTH);
		
		lamina_color = new JPanel();
		
		lamina_color.setBackground(Color.black);
		
		add(lamina_color, BorderLayout.CENTER);
		
	}
	
	private JSlider slider;
	
	private JPanel lamina_color;
	
}

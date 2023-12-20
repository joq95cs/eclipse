package graficos;

import java.awt.*;

import javax.swing.*;

import javax.swing.event.*;

public class PruebaSliders2 {

	public static void main(String[] args) {
		
		MarcoSliders2 marco = new MarcoSliders2();
		
		marco.setVisible(true);

	}

}

class MarcoSliders2 extends JFrame {
	
	public MarcoSliders2() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Sliders 2");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaSliders2 lamina = new LaminaSliders2();
		
		add(lamina);
		
	}
	
}

class LaminaSliders2 extends JPanel {
	
	public LaminaSliders2() {
		
		setLayout(new BorderLayout());
		
		texto = new JLabel("", JLabel.CENTER);
		
		texto.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		texto.setText("Don't wait for luck");
		
		add(texto, BorderLayout.CENTER);
		
		control = new JSlider(10, 50, 15);
		
		control.setMajorTickSpacing(20);
		
		control.setMinorTickSpacing(5);
		
		control.setPaintTicks(true);
		
		control.setFont(new Font("Serif", Font.PLAIN, 10));
		
		control.setPaintLabels(true);
		
		OyenteSlider oyente = new OyenteSlider();
		
		control.addChangeListener(oyente);
		
		JPanel lamina_control = new JPanel();
		
		lamina_control.add(control);
		
		add(lamina_control, BorderLayout.NORTH);
		
	}
	
	private class OyenteSlider implements ChangeListener {
		
		public void stateChanged(ChangeEvent e) {
			
			texto.setFont(new Font("Comic Sans MS", Font.BOLD, control.getValue()));
			
		}
		
	}
	
	private JLabel texto;
	
	private JSlider control;
	
}

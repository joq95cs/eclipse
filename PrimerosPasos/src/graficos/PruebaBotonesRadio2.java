package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class PruebaBotonesRadio2 {

	public static void main(String[] args) {
		
		MarcoBotonesRadio2 marco = new MarcoBotonesRadio2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoBotonesRadio2 extends JFrame {
	
	public MarcoBotonesRadio2() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setSize(ancho/3, alto/3);
		
		setLocation(ancho/3, alto/3);
		
		setTitle("Botones de radio 2");
		
		LaminaBotonesRadio2 lamina = new LaminaBotonesRadio2();
		
		add(lamina);
		
	}
	
}

class LaminaBotonesRadio2 extends JPanel {
	
	public LaminaBotonesRadio2() {
		
		setLayout(new BorderLayout());
		
		texto = new JLabel("Let's go back, back to the beginning...", JLabel.CENTER);
		
		add(texto, BorderLayout.CENTER);
		
		ButtonGroup grupo = new ButtonGroup();
		
		boton1 = new JRadioButton("Pequeño", false);
		
		boton2 = new JRadioButton("Mediano", true);
		
		boton3 = new JRadioButton("Grande", false);
		
		boton4 = new JRadioButton("Muy grande", false);
		
		JPanel laminaRadio = new JPanel();
		
		OyenteBotonesRadio2 oyente = new OyenteBotonesRadio2();
		
		boton1.addActionListener(oyente);
		
		boton2.addActionListener(oyente);
		
		boton3.addActionListener(oyente);
		
		boton4.addActionListener(oyente);
		
		grupo.add(boton1);
		
		grupo.add(boton2);
		
		grupo.add(boton3);
		
		grupo.add(boton4);
		
		laminaRadio.add(boton1);
		
		laminaRadio.add(boton2);
		
		laminaRadio.add(boton3);
		
		laminaRadio.add(boton4);
		
		add(laminaRadio, BorderLayout.SOUTH);
		
	}
	
	private class OyenteBotonesRadio2 implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == boton1) texto.setFont(new Font("Serif", Font.PLAIN, 10));
			
			if(e.getSource() == boton2) texto.setFont(new Font("Serif", Font.PLAIN, 12));
			
			if(e.getSource() == boton3) texto.setFont(new Font("Serif", Font.PLAIN, 18));
			
			if(e.getSource() == boton4) texto.setFont(new Font("Serif", Font.PLAIN, 24));
			
		}
		
	}
	
	private JLabel texto;
	
	private JRadioButton boton1, boton2, boton3, boton4;
	
}

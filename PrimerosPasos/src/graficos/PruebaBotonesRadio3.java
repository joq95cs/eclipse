package graficos;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class PruebaBotonesRadio3 {

	public static void main(String[] args) {
		
		MarcoBotonesRadio3 marco = new MarcoBotonesRadio3();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoBotonesRadio3 extends JFrame {
	
	public MarcoBotonesRadio3() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setSize(ancho/3, alto/3);
		
		setLocation(ancho/3, alto/3);
		
		setTitle("Botones de radio 3");
		
		LaminaBotonesRadio3 lamina = new LaminaBotonesRadio3();
		
		add(lamina);
		
	}
	
}

class LaminaBotonesRadio3 extends JPanel {
	
	public LaminaBotonesRadio3() {
		
		setLayout(new BorderLayout());
		
		texto = new JLabel("Let's go back, back to the beginning...", JLabel.CENTER);
		
		texto.setFont(new Font("Serif", Font.PLAIN, 12));
		
		add(texto, BorderLayout.CENTER);
		
		laminaBotones = new JPanel();
		
		grupo = new ButtonGroup();
		
		colocarBotones("Peque�o", false, 10);
		
		colocarBotones("Mediano", true, 12);
		
		colocarBotones("Grande", false, 16);
		
		colocarBotones("Muy grande", false, 22);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
	}
	
	public void colocarBotones(String nombre, boolean seleccionado, final int tamagno) {
		
		JRadioButton boton = new JRadioButton(nombre, seleccionado);
		
		grupo.add(boton);
		
		laminaBotones.add(boton);
		
		ActionListener oyente = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				texto.setFont(new Font("Serif", Font.PLAIN, tamagno));
				
			}
			
		} ;
		
		boton.addActionListener(oyente);
		
	}
	
	private JLabel texto;
	
	private JRadioButton boton1, boton2, boton3, boton4;
	
	private ButtonGroup grupo;
	
	private JPanel laminaBotones;
	
}


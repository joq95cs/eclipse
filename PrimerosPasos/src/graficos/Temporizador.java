package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Temporizador {

	public static void main(String[] args) {
		
		MarcoTemporizador marco = new MarcoTemporizador();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoTemporizador extends JFrame {
	
	public MarcoTemporizador() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(3*ancho/8, 3*alto/8, ancho/4, alto/4);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/graficos/reloj.gif"));
		
		setTitle("Temporizador");
		
		setResizable(false);
	
		LaminaTemporizador lamina = new LaminaTemporizador();
		
		add(lamina);
		
	}
	
}

class LaminaTemporizador extends JPanel {
	
	public LaminaTemporizador() {
		
		setLayout(new BorderLayout());
		
		JPanel lamina_aux = new JPanel();
		
		boton_iniciar = new JButton("Iniciar");
		
		boton_detener = new JButton("Detener");
		
		boton_reiniciar = new JButton("Reiniciar");
		
		Oyente1 oyente_1 = new Oyente1();
		
		boton_iniciar.addActionListener(oyente_1);
		
		boton_detener.addActionListener(oyente_1);
		
		boton_reiniciar.addActionListener(oyente_1);
		
		lamina_aux.add(boton_iniciar);
		
		lamina_aux.add(boton_detener);
		
		lamina_aux.add(boton_reiniciar);
		
		add(lamina_aux, BorderLayout.NORTH);
		
		etiqueta = new JLabel("0:0:0", JLabel.CENTER);
		
		add(etiqueta, BorderLayout.CENTER);
		
		oyente_2 = new Oyente2();
		
		temporizador = new Timer(1000, oyente_2);
		
	}
	
	private class Oyente1 implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			Object boton_presionado = e.getSource();
			
			if(boton_presionado == boton_iniciar) {
				
				temporizador.start();
				
			}
			
			else if(boton_presionado == boton_detener) {
				
				temporizador.stop();
				
			}
			
			else {
				
				oyente_2.reiniciarValores();
				
				etiqueta.setText("0:0:0");
				
			}
			
		}
		
	}
	
	private class Oyente2 implements ActionListener {
		
		public Oyente2() {
			
			segundos = 0;
			
			minutos = 0;
			
			horas = 0;
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			segundos ++;
			
			if(segundos == 60) {
				
				minutos ++;
				
				segundos = 0;
				
				if(minutos == 60) {
					
					horas ++;
					
					minutos = 0;
					
				}
				
			}
			
			etiqueta.setText(horas + ":" + minutos + ":" + segundos);
			
		}
		
		public void reiniciarValores() {
			
			segundos = 0;
			
			minutos = 0;
			
			horas = 0;
			
		}
		
		private int segundos;
		
		private int minutos;
		
		private int horas;
		
	}
	
	private JButton boton_iniciar;
	
	private JButton boton_detener;
	
	private JButton boton_reiniciar;
	
	private JLabel etiqueta;
	
	private Timer temporizador;
	
	private Oyente2 oyente_2;
	
}

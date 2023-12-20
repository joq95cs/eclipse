package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class PruebaEventos {

	public static void main(String[] args) {
		
		MarcoBotones marco = new MarcoBotones();
		
		marco.setVisible(true);
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

class MarcoBotones extends JFrame {
	
	public MarcoBotones() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = pantalla.getScreenSize();
		
		int ancho = tamagno.width;
		
		int alto = tamagno.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("BOTONES Y EVENTOS");
		
		LaminaBotones lamina = new LaminaBotones();
		
		add(lamina);
		
	}
	
}

class LaminaBotones extends JPanel implements ActionListener {
	
	JButton botonAzul = new JButton("AZUL"); //Se crea el objeto JButton
	
	JButton botonAmarillo = new JButton("AMARILLO");
	
	JButton botonRojo = new JButton("ROJO");
	
	JButton botonRosa = new JButton("ROSA");
	
	public LaminaBotones() {
		
		add(botonAzul);
		
		add(botonAmarillo);
		
		add(botonRojo);
		
		add(botonRosa);
		
		botonAzul.addActionListener(this); //El oyente es la propia lamina, ya que this referencia el propio objeto
		
		//botonAzul es el objeto fuente, al hacer clic se genera un objeto evento, this se refiere al objeto oyente, es decir la propia l�mina
		
		botonAmarillo.addActionListener(this);
		
		botonRojo.addActionListener(this);
		
		botonRosa.addActionListener(this);
		
		//Hay 4 objetos fuentes y un s�lo oyente.
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object botonPulsado = e.getSource();
		
		if(botonPulsado == botonAzul) {
			
			setBackground(Color.BLUE);
			
		}
		
		else if(botonPulsado == botonAmarillo) {
			
			setBackground(Color.YELLOW);
			
		}
		
		else if(botonPulsado == botonRojo) {
			
			setBackground(Color.RED);
			
		}
		
		else {
			
			setBackground(Color.PINK);
			
		}
		
	}
	
}

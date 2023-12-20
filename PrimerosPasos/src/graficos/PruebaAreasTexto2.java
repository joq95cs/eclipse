package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class PruebaAreasTexto2 {

	public static void main(String[] args) {
		
		MarcoAT2 marco = new MarcoAT2();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoAT2 extends JFrame {
	
	public MarcoAT2() {
		
		setLayout(new BorderLayout());
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Prueba areas de texto 2");
		
		setResizable(false);
		
		laminaBotones = new JPanel();
		
		botonInsertar = new JButton("Insertar");
		
		botonInsertar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				areaTexto.append("Once upon a time and place unknown... ");
				
			}
			
		} );
		
		laminaBotones.add(botonInsertar);
		
		botonSaltoLinea = new JButton("Salto de línea");
		
		botonSaltoLinea.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				boolean saltos = !areaTexto.getLineWrap();
				
				areaTexto.setLineWrap(saltos);
				
				if(saltos) {
					
					botonSaltoLinea.setText("Quitar salto");
					
				}
				
				else {
					
					botonSaltoLinea.setText(botonSaltoLinea.getText());
					
				}
				
			}
			
		} );
		
		laminaBotones.add(botonSaltoLinea);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
		areaTexto = new JTextArea(8, 20);
		
		laminaBarras = new JScrollPane(areaTexto);
		
		add(laminaBarras, BorderLayout.CENTER);
		
	}
	
	private JPanel laminaBotones;

	private JButton botonInsertar, botonSaltoLinea;
	
	private JTextArea areaTexto;
	
	private JScrollPane laminaBarras;
	
}

package tap;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.text.*;

import java.util.*;

public class Memoria {

	public static void main(String[] args) {
		
		MarcoMemoria marco = new MarcoMemoria();
		
		marco.setVisible(true);

	}

}

class MarcoMemoria extends JFrame {
	
	public MarcoMemoria() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setTitle("Memoria");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/tap/memoria.png"));
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaMemoria lamina = new LaminaMemoria();
		
		add(lamina);
		
	}
	
}

class LaminaMemoria extends JPanel {
	
	public LaminaMemoria() {
		
		setLayout(new BorderLayout());
		
		lamina_norte = new LaminaNorteMemoria();
		
		add(lamina_norte, BorderLayout.NORTH);
		
		lamina_centro = new LaminaCentroMemoriaCentro();
		
		add(lamina_centro, BorderLayout.CENTER);
		
	}
	
	private class LaminaNorteMemoria extends JPanel {
		
		public LaminaNorteMemoria() {
			
			setLayout(new GridLayout());
			
			campo = new JTextField();
			
			campo.setFont(new Font("Arial", Font.ITALIC, 12));
			
			campo.setHorizontalAlignment(SwingConstants.CENTER);
			
			OyenteMemoria oyente = new OyenteMemoria();
			
			Font fuente_botones = new Font("Arial", Font.BOLD, 12);
			
			boton_int = new JButton("int");
			
			boton_int.setFont(fuente_botones);
			
			boton_int.setBackground(Color.GREEN);
			
			boton_int.addActionListener(oyente);
			
			boton_double = new JButton("double");
			
			boton_double.setFont(fuente_botones);
			
			boton_double.setBackground(Color.YELLOW);
			
			boton_double.addActionListener(oyente);
			
			boton_char = new JButton("char");
			
			boton_char.setFont(fuente_botones);
			
			boton_char.setBackground(Color.CYAN);
			
			boton_char.addActionListener(oyente);
			
			boton_string = new JButton("String");
			
			boton_string.setFont(fuente_botones);
			
			boton_string.setBackground(Color.MAGENTA);
			
			boton_string.addActionListener(oyente);
			
			boton_limpiar = new JButton("Limpiar");
			
			boton_limpiar.setFont(fuente_botones);
			
			boton_limpiar.setBackground(Color.GRAY);
			
			boton_limpiar.addActionListener(oyente);
			
			add(campo);
			
			add(boton_int);
			
			add(boton_double);
			
			add(boton_char);
			
			add(boton_string);
			
			add(boton_limpiar);
			
			oyente.setCampo(campo);
			
			oyente.setBotonInt(boton_int);
			
			oyente.setBotonDouble(boton_double);
			
			oyente.setBotonChar(boton_char);
			
			oyente.setBotonString(boton_string);
			
			oyente.setBotonLimpiar(boton_limpiar);
			
		}
				
		private JTextField campo;
		
		private JButton boton_int;
		
		private JButton boton_double;
		
		private JButton boton_char;
		
		private JButton boton_string;
		
		private JButton boton_limpiar;
		
	}

	private class LaminaCentroMemoriaCentro extends JPanel {
		
		public LaminaCentroMemoriaCentro() {
			
			setLayout(new GridLayout(10, 5));
			
			arreglo = new JTextField[50];
			
			for(int i=0; i<arreglo.length; i++) {
				
				arreglo[i] = new JTextField();
				
				arreglo[i].setEditable(false);
				
				arreglo[i].setBackground(Color.WHITE);
				
				arreglo[i].setFont(new Font("Arial", Font.BOLD, 12));
				
				arreglo[i].setHorizontalAlignment(SwingConstants.CENTER);
				
				add(arreglo[i]);
				
			}
			
			OyenteMemoria.setArreglo(arreglo);
			
		}
		
		private JTextField[] arreglo;
		
	}
	
	private LaminaNorteMemoria lamina_norte;
	
	private LaminaCentroMemoriaCentro lamina_centro;
	
}

class OyenteMemoria implements ActionListener {
	
	public OyenteMemoria() {
		
		contador_1 = 1;
		
		contador_2 = 49;
		
		bloque = "";
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object boton_pulsado = e.getSource();
		
		if(boton_pulsado == boton_int) {
			
			try {
				
				int valor_int = Integer.parseInt(campo.getText());
				
				String valor_binario = Integer.toBinaryString(valor_int);
				
				for(int i=0; i<valor_binario.length(); i++) {
					
					if(contador_1 == 9) {
						
						contador_2 --;
						
						contador_1 = 1;
						
						bloque = "";
						
					}
					
					if(contador_2 == -1) {
						
						JOptionPane.showMessageDialog(null, "La memoria está al límite");
						
						campo.setEditable(false);
						
						boton_int.setEnabled(false);
						
						boton_double.setEnabled(false);
						
						boton_char.setEnabled(false);
						
						boton_string.setEnabled(false);
						
						i = valor_binario.length();
						
					} else {
						
						bloque += valor_binario.charAt(i);
						
						arreglo[contador_2].setText(bloque);
						
						arreglo[contador_2].setBackground(Color.GREEN);
						
						contador_1 ++;
						
					}
					
				}
				
			} catch(Exception e_int) {
				
				JOptionPane.showMessageDialog(null, e_int.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				
				campo.setText("");
				
			}
			
		} else if(boton_pulsado == boton_double) {
			
			try {
				
				double valor_double = Double.parseDouble(campo.getText());
				
				String aux_valor_double_1 = "" + valor_double;
				
				String aux_valor_double_2 = "";
					
				for(int i=0; i<aux_valor_double_1.length(); i++) {
						
					if(aux_valor_double_1.charAt(i) != '.') {
							
						aux_valor_double_2 += aux_valor_double_1.charAt(i);
							
					} else { 
							
						aux_valor_double_2 += '1';
							
					}
						
				}
				
				long valor_long = (long)Double.parseDouble(aux_valor_double_2);
				
				String valor_binario = Long.toBinaryString(valor_long);
				
				for(int i=0; i<valor_binario.length(); i++) {
					
					if(contador_1 == 9) {
						
						contador_2 --;
						
						contador_1 = 1;
						
						bloque = "";
						
					}
					
					if(contador_2 == -1) {
						
						JOptionPane.showMessageDialog(null, "La memoria está al límite");
						
						campo.setEditable(false);
						
						boton_int.setEnabled(false);
						
						boton_double.setEnabled(false);
						
						boton_char.setEnabled(false);
						
						boton_string.setEnabled(false);
						
						i = valor_binario.length();
						
					} else {
						
						bloque += valor_binario.charAt(i);
						
						arreglo[contador_2].setText(bloque);
						
						arreglo[contador_2].setBackground(Color.YELLOW);
						
						contador_1 ++;
						
					}
					
				}
				
			} catch(Exception e_double) {
				
				JOptionPane.showMessageDialog(null, e_double.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				
				campo.setText("");
				
			}
			
		} else if(boton_pulsado == boton_char) {
			
			try {
				
				char valor_char = campo.getText().charAt(0);
				
				int codigo_char = valor_char;
				
				String valor_binario = Integer.toBinaryString(codigo_char);
				
				for(int i=0; i<valor_binario.length(); i++) {
					
					if(contador_1 == 9) {
						
						contador_2 --;
						
						contador_1 = 1;
						
						bloque = "";
						
					}
					
					if(contador_2 == -1) {
						
						JOptionPane.showMessageDialog(null, "La memoria está al límite");
						
						campo.setEditable(false);
						
						boton_int.setEnabled(false);
						
						boton_double.setEnabled(false);
						
						boton_char.setEnabled(false);
						
						boton_string.setEnabled(false);
						
						i = valor_binario.length();
						
					} else {
						
						bloque += valor_binario.charAt(i);
						
						arreglo[contador_2].setText(bloque);
						
						arreglo[contador_2].setBackground(Color.CYAN);
						
						contador_1 ++;
						
					}
					
				}
				
			} catch(Exception e_char) {
				
				JOptionPane.showMessageDialog(null, e_char.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
				campo.setText("");
				
			}
			
		} else if(boton_pulsado == boton_string) {
			
			char[] caracteres = new char[campo.getText().length()];
			
			for(int i=0; i<caracteres.length; i++) {
				
				caracteres[i] = campo.getText().charAt(i);
				
			}
			
			int aux = 0;
			
			for(int i=0; i<caracteres.length; i++) {
				
				aux += caracteres[i];
				
			}
			
			String valor_binario = Integer.toBinaryString(aux);
			
			for(int i=0; i<valor_binario.length(); i++) {
				
				if(contador_1 == 9) {
					
					contador_2 --;
					
					contador_1 = 1;
					
					bloque = "";
					
				}
				
				if(contador_2 == -1) {
					
					JOptionPane.showMessageDialog(null, "La memoria está al límite");
					
					campo.setEditable(false);
					
					boton_int.setEnabled(false);
					
					boton_double.setEnabled(false);
					
					boton_char.setEnabled(false);
					
					boton_string.setEnabled(false);
					
					i = valor_binario.length();
					
				} else {
					
					bloque += valor_binario.charAt(i);
					
					arreglo[contador_2].setText(bloque);
					
					arreglo[contador_2].setBackground(Color.MAGENTA);
					
					contador_1 ++;
					
				}
				
			}
			
		} else {
			
			for(int i=0; i<arreglo.length; i++) {
				
				arreglo[i].setText("");
				
				arreglo[i].setBackground(Color.WHITE);
				
			}
			
			if(contador_2 == -1) {
				
				campo.setEditable(true);
				
				boton_int.setEnabled(true);
				
				boton_double.setEnabled(true);
				
				boton_char.setEnabled(true);
				
				boton_string.setEnabled(true);
				
			}
			
			contador_1 = 1;
			
			contador_2 = 49;
			
			bloque = "";
			
		}
		
	}
	
	public void setBotonInt(JButton boton_int) {
		
		this.boton_int = boton_int;
		
	}
	
	public void setBotonDouble(JButton boton_double) {
		
		this.boton_double = boton_double;
		
	}
	
	public void setBotonChar(JButton boton_char) {
		
		this.boton_char = boton_char;
		
	}
	
	public void setBotonString(JButton boton_string) {
		
		this.boton_string = boton_string;
		
	}
	
	public void setBotonLimpiar(JButton boton_limpiar) {
		
		this.boton_limpiar = boton_limpiar;
		
	}
	
	public void setCampo(JTextField campo) {
		
		this.campo = campo;
		
	}
	
	public static void setArreglo(JTextField[] a) {
		
		arreglo = a;
		
	}
	
	private JTextField campo;

	private JButton boton_int;
	
	private JButton boton_double;
	
	private JButton boton_char;
	
	private JButton boton_string;
	
	private JButton boton_limpiar;
	
	private static JTextField arreglo[];
	
	private static int contador_1;
	
	private static int contador_2;
	
	private static String bloque;
	
}


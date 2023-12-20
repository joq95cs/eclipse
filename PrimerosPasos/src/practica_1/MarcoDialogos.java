package practica_1;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.awt.geom.*;

import java.util.*;

public class MarcoDialogos extends JFrame {
	
	public MarcoDialogos() {
		
		setTitle("Prueba de diálogos");
		
		setSize(600, 450);
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setLocation(w/2 - getWidth()/2, h/2 - getHeight()/2);
		
		JPanel laminaCuadricula = new JPanel();
		
		laminaCuadricula.setLayout(new GridLayout(2, 3));
		
		add(laminaCuadricula);
		
		laminaTipo = new LaminaBotones("Tipo", new String[] {
				
				"Mensaje",
				"Confirmar",
				"Opción",
				"Entrada"
				
		}); // Se instancia el arreglo directamente
		
		laminaTipoMensaje = new LaminaBotones("Tipo de mensaje", new String[] {
				
				"ERROR_MESSAGE",
				"INFORMATION_MESSAGE",
				"WARNING_MESSAGE",
				"QUESTION_MESSAGE",
				"PLAIN_MESSAGE",
				
		});
		
		laminaMensaje = new LaminaBotones("Mensaje", new String[] {
				
				"Cadena",
				"Ícono",
				"Componente",
				"Otros",
				"Object[]"
				
				
		});
		
		laminaConfirmar = new LaminaBotones("Confirmar", new String[] {
				
				"DEFAULT_OPTION",
				"YES_NO_OPTION",
				"YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION"
				
				
		});
		
		laminaOpcion = new LaminaBotones("Opción", new String[] {
				
				"String[]",
				"Icon[]",
				"Object[]",
				
				
		});
		
		laminaEntrada = new LaminaBotones("Entrada", new String[] {
				
				"Campo de texto",
				"Combo",
				
		});
		
		laminaCuadricula.add(laminaTipo); //Se agrega la primera caja
		
		laminaCuadricula.add(laminaTipoMensaje);
		
		laminaCuadricula.add(laminaMensaje);
		
		laminaCuadricula.add(laminaConfirmar);
		
		laminaCuadricula.add(laminaOpcion);
		
		laminaCuadricula.add(laminaEntrada);
		
		setLayout(new BorderLayout());
		
		add(laminaCuadricula, BorderLayout.CENTER);
		
		JPanel laminaBoton = new JPanel();
		
		JButton boton = new JButton("Mostrar");
		
		boton.addActionListener(new OyenteMostrar());
		
		laminaBoton.add(boton);
		
		add(laminaBoton, BorderLayout.SOUTH);
		
	}
	
	//Regresa el mensaje
	
	public Object getMensaje() {
		
		String c = laminaMensaje.seleccion();
		
		if(c.equals("Cadena")) {
			
			return cadenaMensaje;
			
		} else if(c.equals("Ícono")) {
			
			return iconoMensaje;
			
		} else if(c.equals("Componente")) {
			
			return componenteMensaje;
			
		} else if(c.equals("Otros")) {
			
			return objetoMensaje;
			
		} else if(c.equals("Object[]")) {
			
			return new Object[] {
					
					cadenaMensaje, 
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
					
			};
			
		} else {
			
			return null;
			
		}
		
	}
	
	//Regresa el ícono y los botones de confirmar
	
	public int getIconoOpciones(LaminaBotones lamina) {
		
		String c = lamina.seleccion();
		
		if(c.equals("ERROR_MESSAGE") || c.equals("YES_NO_OPTION")) {
			
			return 0;
			
		} else if(c.equals("INFORMATION_MESSAGE") || c.equals("YES_NO_CANCEL_OPTION")) {
			
			return 1;
			
		} else if(c.equals("WARNING_MESSAGE") || c.equals("OK_CANCEL_OPTION")) {
			
			return 2;
			
		} else if(c.equals("QUESTION_MESSAGE")) {
			
			return 3;
			
		} else if(c.equals("PLAIN_MESSAGE") || c.equals("DEFAULT_OPTION")) {
			
			return -1;
			
		} else {
			
			return 0;
			
		}
		
	}
	
	//Regresa opciones de la lámina opción
	
	public Object[] getOpciones(LaminaBotones lamina) {
		
		String c = lamina.seleccion();
		
		if(c.equals("String[]")) {
			
			return new String[] {"Amarillo", "Verde", "Rojo"};
			
		} else if(c.equals("Icon[]")) {
			
			return new Icon[] {new ImageIcon("src/practica_1/bolaAmarilla.gif"), new ImageIcon("src/practica_1/bolaRoja.gif"), new ImageIcon("src/practica_1/bolaVerde.gif")};
			
		} else if(c.equals("Object[]")) {
			
			return new Object[] {
					
					cadenaMensaje, 
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
					
			};
			
		} else {
			
			return null;
			
		}
		
	}
	
	private class OyenteMostrar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(laminaTipo.seleccion().equals("Mensaje")) {
				
				JOptionPane.showMessageDialog(MarcoDialogos.this, getMensaje(), "Título", getIconoOpciones(laminaTipoMensaje));
				
			} else if(laminaTipo.seleccion().equals("Confirmar")) {
				
				JOptionPane.showConfirmDialog(MarcoDialogos.this, getMensaje(), "Título", getIconoOpciones(laminaConfirmar), getIconoOpciones(laminaTipoMensaje));
				
			} else if(laminaTipo.seleccion().equals("Entrada")) {
				
				if(laminaEntrada.seleccion().equals("Campo de texto")) {
				
					JOptionPane.showInputDialog(MarcoDialogos.this, getMensaje(), "Título", getIconoOpciones(laminaTipoMensaje));
				
				} else {
					
					JOptionPane.showInputDialog(MarcoDialogos.this, getMensaje(), "Título", getIconoOpciones(laminaTipoMensaje), null, new String[] {"Amarillo", "Verde", "Rojo"}, "Amarillo");
					
				}
					
			} else {
				
				JOptionPane.showOptionDialog(MarcoDialogos.this, getMensaje(), "Título", 1, getIconoOpciones(laminaTipoMensaje), null, getOpciones(laminaOpcion), null);
				
			}
			
		}
		
	}
	
	private LaminaBotones laminaTipo, laminaTipoMensaje, laminaMensaje, laminaConfirmar, laminaOpcion, laminaEntrada;
	
	private String cadenaMensaje = "Mensaje";
	
	private Icon iconoMensaje = new ImageIcon("src/practica_1/bolaVerde.gif");
	
	private Object objetoMensaje = new Date();
	
	private Component componenteMensaje = new LaminaEjemplo();
	
}

class LaminaEjemplo extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponents(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		
		g2.setPaint(Color.YELLOW); //Le damos color al rectangulo
		
		g2.fill(rectangulo);
		
	}
	
}
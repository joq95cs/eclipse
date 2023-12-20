package tap;

import javax.swing.*;

import java.awt.*;

import java.util.*;

import java.awt.event.*;

public class ImpresionNumeros {

	public static void main(String[] args) {
		
		MarcoImpresionNumeros marco = new MarcoImpresionNumeros();
		
		marco.setVisible(true);

	}

}

class MarcoImpresionNumeros extends JFrame {
	
	public MarcoImpresionNumeros() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Impresión de números");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaImpresionNumeros lamina = new LaminaImpresionNumeros();
		
		add(lamina);
		
	}
	
}

class LaminaImpresionNumeros extends JPanel {
	
	public LaminaImpresionNumeros() {
		
		setLayout(new BorderLayout());
		
		laminaNorte = new JPanel();
		
		laminaNorte.setLayout(new GridLayout());
		
		campoEntrada = new JTextField();
		
		campoEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		
		AccionImpresionNumeros accionIngresar = new AccionImpresionNumeros("Ingresar número");
		
		AccionImpresionNumeros accionImprimir = new AccionImpresionNumeros("Imprimir resultado");
		
		botonEntrada = new JButton(accionIngresar);
		
		botonImprimir = new JButton(accionImprimir);
		
		laminaNorte.add(campoEntrada);
		
		laminaNorte.add(botonEntrada);
		
		laminaNorte.add(botonImprimir);
		
		laminaCentro = new JPanel();
		
		laminaCentro.setLayout(new BorderLayout());
		
		etiqueta = new JLabel("Resultado", SwingConstants.CENTER);
		
		laminaCentro.add(etiqueta, BorderLayout.SOUTH);
		
		laminaSur = new JPanel();
		
		laminaSur.setLayout(new GridLayout());
		
		campoResultado = new JTextField();
		
		campoResultado.setHorizontalAlignment(SwingConstants.CENTER);
		
		campoResultado.setEditable(false);
		
		campoResultado.setBackground(Color.CYAN);
		
		laminaSur.add(campoResultado);
		
		add(laminaNorte, BorderLayout.NORTH);
		
		add(laminaCentro,BorderLayout.CENTER);
		
		add(laminaSur, BorderLayout.SOUTH);
		
		objetoNumeros = new Numeros();
		
		InputMap mapaEntrada = campoEntrada.getInputMap(JComponent.WHEN_FOCUSED);
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "botonIngresar");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "botonImprimir");
		
		ActionMap mapaAccion = campoEntrada.getActionMap();
		
		mapaAccion.put("botonIngresar", accionIngresar);
		
		mapaAccion.put("botonImprimir", accionImprimir);
		
	}
	
	private class AccionImpresionNumeros extends AbstractAction {
		
		public AccionImpresionNumeros(String rotuloBoton) {
			
			putValue(Action.NAME, rotuloBoton);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			String botonPresionado = getValue(Action.NAME).toString();
			
			if(botonPresionado.equals("Ingresar número")) {
				
				numeros.add(Double.valueOf(Double.parseDouble(campoEntrada.getText())));
				
			} else {
				
				int aux = objetoNumeros.setPrimerNumero(numeros.get(0));
				
				if(aux == 1) {
					
					for(int i=1; i<numeros.size(); i++) {
						
						if(numeros.get(i) != 0) {
							
							aux = objetoNumeros.setPrimerNumero(numeros.get(i));
							
							i = numeros.size();
							
						}
						
					}
					
				}
				
				if(aux == 1) {
					
					campoResultado.setText("No se ingresaron números diferentes a 0");
					
				} else {
					
					objetoNumeros.obtenerResultado();
					
					campoResultado.setText(resultado);
					
				}
				
				numeros = new ArrayList<Double>();
				
				resultado = "";
				
			}
			
		}
		
	}
	
	private class Numeros {
		
		public Numeros() {
			
			numeros = new ArrayList<Double>();
			
			resultado = "";
			
		}
		
		public int setPrimerNumero(double primerNum) {
			
			if(primerNum != 0) {
				
				primerNumero = primerNum;
				
				return 0;
				
			}
			
			return 1;
			
		}
		
		public void obtenerResultado() {
			
			boolean aux1 = true;
			
			boolean aux2 = false;
			
			int j = 0;
			
			for(int i=0; i<numeros.size(); i++) {
					
				if(aux1 == true) {
					
					for(j=0; j<numeros.size(); j++) {
						
						if(numeros.get(j) % primerNumero == 0 && numeros.get(j) != 0) {
								
							resultado += (numeros.get(j));
								
							j = numeros.size();
							
							aux1 = false;
								
						}
						
					}
					
				}
					
				if(numeros.get(i) % primerNumero == 0 && numeros.get(i) != 0) {
						
					if(aux2 == true) {
							
						resultado += (", " + numeros.get(i));
							
					}
						
					aux2 = true;
						
				}
					
			}
				
		}
			
	}
	
	private JTextField campoEntrada;
	
	private JTextField campoResultado;
	
	private JButton botonEntrada;
	
	private JButton botonImprimir;
	
	private JLabel etiqueta;
	
	private JPanel laminaNorte;
	
	private JPanel laminaSur;
	
	private JPanel laminaCentro;
	
	private Numeros objetoNumeros;
	
	private ArrayList<Double> numeros;
	
	private double primerNumero;
	
	private String resultado;
	
}
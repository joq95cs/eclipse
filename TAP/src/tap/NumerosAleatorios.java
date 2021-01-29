package tap;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class NumerosAleatorios {

	public static void main(String[] args) {
		
		MarcoNA marco = new MarcoNA();
		
		marco.setVisible(true);

	}

}

class MarcoNA extends JFrame {
	
	public MarcoNA() {
		
		ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		this.setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setTitle("Números aleatorios");
		
		this.setResizable(false);
		
		LaminaNA lamina = new LaminaNA();
		
		this.add(lamina);
		
	}
	
	private int ancho;
	
	private int alto;
	
}

class LaminaNA extends JPanel {
	
	public LaminaNA() {
		
		this.setLayout(new BorderLayout());
		
		area_resultado = new JTextArea();
		
		area_resultado.setLineWrap(true);
		
		area_resultado.setEditable(false);
		
		panel_scroll = new JScrollPane(area_resultado);
		
		this.add(panel_scroll, BorderLayout.EAST);
		
		lamina_centro = new JPanel();
		
		lamina_centro.setLayout(new GridLayout(4, 1));
		
		this.add(lamina_centro, BorderLayout.CENTER);
		
		lamina_fila1 = new JPanel();
		
		lamina_fila2 = new JPanel();
		
		lamina_fila3 = new JPanel();
		
		lamina_fila4 = new JPanel();
		
		lamina_centro.add(lamina_fila1);
		
		lamina_centro.add(lamina_fila2);
		
		lamina_centro.add(lamina_fila3);
		
		lamina_centro.add(lamina_fila4);
		
		etiqueta6 = new JLabel("Cantidad de elementos del arreglo ");
		
		campo3 = new JTextField(3);
		
		lamina_fila1.add(etiqueta6);
		
		lamina_fila1.add(campo3);
		
		etiqueta1 = new JLabel("Número inicial ");
		
		combo1 = new JComboBox();
		
		combo1.addItem("1");
		
		combo1.addItem("2");
		
		combo1.addItem("3");
		
		combo1.addItem("4");
		
		combo1.addItem("5");
		
		combo1.addItem("6");
		
		combo1.addItem("7");
		
		combo1.addItem("8");
		
		combo1.addItem("9");
		
		combo1.addItem("10");
		
		etiqueta2 = new JLabel("Número final ");
		
		combo2 = new JComboBox();
		
		combo2.addItem("0");
		
		combo2.addItem("1");
		
		combo2.addItem("2");
		
		combo2.addItem("3");
		
		combo2.addItem("4");
		
		combo2.addItem("5");
		
		combo2.addItem("6");
		
		combo2.addItem("7");
		
		combo2.addItem("8");
		
		combo2.addItem("9");
		
		combo2.addItem("10");
		
		lamina_fila2.add(etiqueta1);
		
		lamina_fila2.add(combo1);
		
		lamina_fila2.add(etiqueta2);
		
		lamina_fila2.add(combo2);
		
		etiqueta3 = new JLabel("El número ");
		
		campo1 = new JTextField(3);
		
		campo1.setEditable(false);
		
		etiqueta4 = new JLabel(" se repite ");
		
		campo2 = new JTextField(3);
		
		campo2.setEditable(false);
		
		etiqueta5 = new JLabel(" veces");
		
		lamina_fila3.add(etiqueta3);
		
		lamina_fila3.add(campo1);
		
		lamina_fila3.add(etiqueta4);
		
		lamina_fila3.add(campo2);
		
		lamina_fila3.add(etiqueta5);
		
		boton_resultado = new JButton("Generar arreglo y contar");
		
		MouseListener oyente = new OyenteNA();
		
		boton_resultado.addMouseListener(oyente);
		
		lamina_fila4.add(boton_resultado);
		
	}
	
	private class OyenteNA extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			
			ArregloNA.iniciarArreglo(Integer.parseInt(campo3.getText()));
			
			ArregloNA.setNumeroInicial(Double.parseDouble(combo1.getSelectedItem().toString()));
			
			ArregloNA.setNumeroFinal(Double.parseDouble(combo2.getSelectedItem().toString()));
			
			ArregloNA.llenarArreglo();
			
			String resultado = "";
			
			for(int i=0; i<Integer.parseInt(campo3.getText()); i++) {
				
				resultado += ("[ " + ArregloNA.getElemento(i) + " ]\n"); 
				
			}
			
			area_resultado.setText(resultado);
			
			campo1.setText(combo2.getSelectedItem().toString());
			
			ArregloNA.setNumeroVecesNF();
			
			campo2.setText("" + ArregloNA.getNumeroVecesNF());
			
		}
		
	}
	
	private JTextArea area_resultado;
	
	private JScrollPane panel_scroll;
	
	private JPanel lamina_centro;
	
	private JPanel lamina_fila1;
	
	private JPanel lamina_fila2;
	
	private JPanel lamina_fila3;
	
	private JPanel lamina_fila4;
	
	private JLabel etiqueta1;
	
	private JLabel etiqueta2;
	
	private JLabel etiqueta3;
	
	private JLabel etiqueta4;
	
	private JLabel etiqueta5;
	
	private JLabel etiqueta6;
	
	private JComboBox combo1;
	
	private JComboBox combo2;
	
	private JTextField campo1;
	
	private JTextField campo2;
	
	private JTextField campo3;
	
	private JButton boton_resultado;
	
}

class ArregloNA {
	
	public static void iniciarArreglo(int no_elementos) {
		
		arreglo = new double[no_elementos];
		
	}
	
	public static void llenarArreglo() {
		
		for(int i=0; i<arreglo.length; i++) {
			
			arreglo[i] = Math.round(Math.random()*(numero_inicial-numero_final)+numero_final);
			
		}
		
	}
	
	public static void setNumeroInicial(double ni) {
		
		numero_inicial = ni;
		
	}
	
	public static void setNumeroFinal(double nf) {
		
		numero_final = nf;
		
	}
	
	public static void setNumeroVecesNF() {
		
		numero_veces_nf = 0;
		
		for(int i=0; i<arreglo.length; i++) {
			
			if(arreglo[i] == numero_final) {
				
				numero_veces_nf ++;
				
			}
			
		}
		
	}
	
	public static double getElemento(int i) {
		
		return arreglo[i];
		
	}
	
	public static int getNumeroVecesNF() {
		
		return numero_veces_nf;
		
	}
	
	private static double[] arreglo;
	
	private static double numero_inicial;
	
	private static double numero_final;
	
	private static int numero_veces_nf;
	
}


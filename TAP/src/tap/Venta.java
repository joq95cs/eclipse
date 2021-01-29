package tap;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class Venta {

	public static void main(String[] args) {
		
		MarcoVenta marco = new MarcoVenta();
		
		marco.setVisible(true);
		
	}

}

class MarcoVenta extends JFrame {
	
	public MarcoVenta() {
		
		anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setSize(5*anchoPantalla/9, 3*altoPantalla/9);
		
		setLocation(2*anchoPantalla/9, 3*altoPantalla/9);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Venta");
		
		lamina = new LaminaVenta();
		
		add(lamina);
		
	}
	
	private int anchoPantalla;
	
	private int altoPantalla;
	
	private LaminaVenta lamina;
	
}

class LaminaVenta extends JPanel {
	
	public LaminaVenta() {
		
		setLayout(new BorderLayout());
		
		areaImpresion = new JTextArea("DETALLES DE LAS VENTAS");
		
		areaImpresion.setLineWrap(false);
		
		laminaScroll = new JScrollPane(areaImpresion);
		
		laminaIzquierda = new JPanel();
		
		laminaIzquierda.setLayout(new GridLayout(2, 1));
		
		add(laminaIzquierda, BorderLayout.CENTER);
		
		add(laminaScroll, BorderLayout.EAST);
		
		lamina1 = new JPanel();
		
		lamina1.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		lamina2 = new JPanel();
		
		lamina2.setLayout(new FlowLayout(FlowLayout.CENTER));

		laminaIzquierda.add(lamina1);
		
		laminaIzquierda.add(lamina2);
		
		etiquetaMonto = new JLabel("Monto: $");
		
		campoMonto = new JTextField(9);
		
		botonIVA = new JButton("Calcular IVA");
		
		etiquetaIVA = new JLabel("IVA: $");
		
		campoIVA = new JTextField(9);
		
		campoIVA.setEditable(false);
		
		etiquetaTotal = new JLabel("Total: $");
		
		campoTotal = new JTextField(9);
		
		campoTotal.setEditable(false);
		
		lamina1.add(etiquetaMonto);
		
		lamina1.add(campoMonto);
		
		lamina1.add(botonIVA);
		
		lamina1.add(etiquetaIVA);
		
		lamina1.add(campoIVA);
		
		lamina1.add(etiquetaTotal);
		
		lamina1.add(campoTotal);
		
		etiquetaPago = new JLabel("Pago: $");
		
		campoPago = new JTextField(9);
		
		botonPagar = new JButton("Pagar");
		
		etiquetaCambio = new JLabel("Cambio: $");
		
		campoCambio = new JTextField(9);
		
		campoCambio.setEditable(false);
		
		botonLimpiar = new JButton("Limpiar registros");
		
		lamina2.add(etiquetaPago);
		
		lamina2.add(campoPago);
		
		lamina2.add(botonPagar);
		
		lamina2.add(etiquetaCambio);
		
		lamina2.add(campoCambio);
		
		lamina2.add(botonLimpiar);
		
		OyenteVenta oyente = new OyenteVenta();
		
		oyente.setBotonIVA(botonIVA);
		
		oyente.setBotonPagar(botonPagar);
		
		oyente.setAreaImpresion(areaImpresion);
		
		botonIVA.addMouseListener(oyente);
		
		botonPagar.addMouseListener(oyente);
		
		botonLimpiar.addMouseListener(oyente);
		
	}
	
	public static JTextField getCampoMonto() {
		
		return campoMonto;
		
	}
	
	public static JTextField getCampoPago() {
		
		return campoPago;
		
	}
	
	public static JTextField getCampoIVA() {
		
		return campoIVA;
		
	}
	
	public static JTextField getCampoTotal() {
		
		return campoTotal;
		
	}
	
	public static JTextField getCampoCambio() {
		
		return campoCambio;
		
	}
	
	private static JTextArea areaImpresion;
	
	private static JScrollPane laminaScroll;
	
	private static JPanel laminaIzquierda;
	
	private static JPanel lamina1;
	
	private static JPanel lamina2;
	
	private static JButton botonIVA;
	
	private static JButton botonPagar;
	
	private static JButton botonLimpiar;
	
	private static JLabel etiquetaMonto;
	
	private static JLabel etiquetaIVA;
	
	private static JLabel etiquetaTotal;
	
	private static JLabel etiquetaPago;
	
	private static JLabel etiquetaCambio;
	
	private static JTextField campoMonto;
	
	private static JTextField campoIVA;
	
	private static JTextField campoTotal;
	
	private static JTextField campoPago;
	
	private static JTextField campoCambio;
	
	
}
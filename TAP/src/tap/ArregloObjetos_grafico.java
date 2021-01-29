package tap;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.util.*;

public class ArregloObjetos_grafico {

	public static void main(String[] args) {
		
		MarcoObjetos marco = new MarcoObjetos();
		
		marco.setVisible(true);

	}

}

class MarcoObjetos extends JFrame {
	
	public MarcoObjetos() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setTitle("Arreglo de objetos");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		LaminaObjetos lamina = new LaminaObjetos();
		
		add(lamina);
		
	}
	
}

class LaminaObjetos extends JPanel {
	
	public LaminaObjetos() {
		
		contador = 0;
		
		personas = new ArrayList<Persona>();
		
		AccionObjetos accionIngresar = new AccionObjetos("Ingresar (ctrl + I)");
		
		AccionObjetos accionImprimir = new AccionObjetos("Imprimir (ctrl + M)");
		
		AccionObjetos accionLimpiar = new AccionObjetos("Limpiar (ctrl + L)");
		
		setLayout(new BorderLayout());
		
		laminaCampos = new JPanel();
		
		campoNombre = new JTextField();
		
		campoNombre.setHorizontalAlignment(SwingConstants.CENTER);
		
		campoEdad = new JTextField();
		
		campoEdad.setHorizontalAlignment(SwingConstants.CENTER);
		
		campoSexo = new JTextField();
		
		campoSexo.setHorizontalAlignment(SwingConstants.CENTER);
		
		etiquetaNombre = new JLabel("Nombre: ");
		
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		
		etiquetaEdad = new JLabel("Edad: ");
		
		etiquetaEdad.setHorizontalAlignment(SwingConstants.CENTER);
		
		etiquetaSexo = new JLabel("Sexo: ");
		
		etiquetaSexo.setHorizontalAlignment(SwingConstants.CENTER);
		
		laminaCampos.setLayout(new GridLayout());
		
		laminaCampos.add(etiquetaNombre);
		
		laminaCampos.add(campoNombre);
		
		laminaCampos.add(etiquetaEdad);
		
		laminaCampos.add(campoEdad);
		
		laminaCampos.add(etiquetaSexo);
		
		laminaCampos.add(campoSexo);
		
		laminaBotones = new JPanel();
		
		botonAgregar = new JButton(accionIngresar);
		
		botonImprimir = new JButton(accionImprimir);
		
		botonLimpiar = new JButton(accionLimpiar);
		
		laminaBotones.add(botonAgregar);
		
		laminaBotones.add(botonImprimir);
		
		laminaBotones.add(botonLimpiar);
		
		laminaNorte = new JPanel();
		
		laminaNorte.setLayout(new GridLayout(2, 1));
		
		laminaNorte.add(laminaCampos);
		
		laminaNorte.add(laminaBotones);
		
		add(laminaNorte, BorderLayout.NORTH);
		
		area = new JTextArea();
		
		area.setLineWrap(true);
		
		area.setEditable(false);
		
		laminaScroll = new JScrollPane(area);
		
		add(laminaScroll, BorderLayout.CENTER);
		
		InputMap mapaEntradaCN = campoNombre.getInputMap(JComponent.WHEN_FOCUSED);
		
		InputMap mapaEntradaCE = campoEdad.getInputMap(JComponent.WHEN_FOCUSED);
		
		InputMap mapaEntradaCS = campoSexo.getInputMap(JComponent.WHEN_FOCUSED);
		
		mapaEntradaCN.put(KeyStroke.getKeyStroke("ctrl I"), "Ingresar");
		
		mapaEntradaCE.put(KeyStroke.getKeyStroke("ctrl I"), "Ingresar");
		
		mapaEntradaCS.put(KeyStroke.getKeyStroke("ctrl I"), "Ingresar");
		
		mapaEntradaCN.put(KeyStroke.getKeyStroke("ctrl M"), "Mostrar");
		
		mapaEntradaCE.put(KeyStroke.getKeyStroke("ctrl M"), "Mostrar");
		
		mapaEntradaCS.put(KeyStroke.getKeyStroke("ctrl M"), "Mostrar");
		
		mapaEntradaCN.put(KeyStroke.getKeyStroke("ctrl L"), "Limpiar");
		
		mapaEntradaCE.put(KeyStroke.getKeyStroke("ctrl L"), "Limpiar");
		
		mapaEntradaCS.put(KeyStroke.getKeyStroke("ctrl L"), "Limpiar");
		
		ActionMap mapaAccionCN = campoNombre.getActionMap();
		
		ActionMap mapaAccionCE = campoEdad.getActionMap();
		
		ActionMap mapaAccionCS = campoSexo.getActionMap();
		
		mapaAccionCN.put("Ingresar", accionIngresar);
		
		mapaAccionCN.put("Mostrar", accionImprimir);
		
		mapaAccionCN.put("Limpiar", accionLimpiar);
		
		mapaAccionCE.put("Ingresar", accionIngresar);
		
		mapaAccionCE.put("Mostrar", accionImprimir);
		
		mapaAccionCE.put("Limpiar", accionLimpiar);
		
		mapaAccionCS.put("Ingresar", accionIngresar);
		
		mapaAccionCS.put("Mostrar", accionImprimir);
		
		mapaAccionCS.put("Limpiar", accionLimpiar);
		
	}
	
	private class AccionObjetos extends AbstractAction {
		
		public AccionObjetos(String rotuloBoton) {
			
			putValue(Action.NAME, rotuloBoton);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			String botonPresionado = getValue(Action.NAME).toString();
			
			if(botonPresionado.equals("Ingresar (ctrl + I)")) {
				
				personas.add(new Persona());
				
				personas.get(contador).setDatos(campoNombre.getText(), campoSexo.getText(), Integer.parseInt(campoEdad.getText()));
				
				contador ++;
				
			} else if(botonPresionado.equals("Imprimir (ctrl + M)")) {
				
				String datos = "";
				
				for(int i=0; i<personas.size(); i++) {
					
					datos += personas.get(i).getDatosG();
					
				}
				
				area.setText(datos);
				
			} else {
				
				contador = 0;
				
				personas = new ArrayList<Persona>();
				
			}
			
		}
		
	}
	
	private JPanel laminaNorte;
	
	private JPanel laminaCampos;
	
	private JPanel laminaBotones;
	
	private JTextField campoNombre;
	
	private JTextField campoEdad;
	
	private JTextField campoSexo;
	
	private JLabel etiquetaNombre;
	
	private JLabel etiquetaEdad;
	
	private JLabel etiquetaSexo;
	
	private JButton botonAgregar;
	
	private JButton botonImprimir;
	
	private JButton botonLimpiar;
	
	private JScrollPane laminaScroll;
	
	private JTextArea area;
	
	private ArrayList<Persona> personas;
	
	private static int contador;
	
}

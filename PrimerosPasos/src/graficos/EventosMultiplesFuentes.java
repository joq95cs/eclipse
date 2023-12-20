package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosMultiplesFuentes {

	public static void main(String[] args) {
		
		MarcoEventosMultiplesFuentes marco = new MarcoEventosMultiplesFuentes();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class MarcoEventosMultiplesFuentes extends JFrame {
	
	public MarcoEventosMultiplesFuentes() {
		
		Dimension dimensiones = Toolkit.getDefaultToolkit().getScreenSize();
		
		int ancho = dimensiones.width, alto = dimensiones.height;
		
		setBounds(ancho/4, alto/4, ancho/2, alto/2);
		
		setResizable(false);
		
		setTitle("Eventos multiples fuentes");
		
		PanelEventosMultiplesFuentes lamina = new PanelEventosMultiplesFuentes();
		
		add(lamina);
		
	}
	
}

class PanelEventosMultiplesFuentes extends JPanel {
	
	public PanelEventosMultiplesFuentes() {
		
		/*JButton botonAmarillo = new JButton("Amarillo");
		
		JButton botonRojo = new JButton("Rojo");
		
		JButton botonVerde = new JButton("Verde");
		
		add(botonAmarillo);
		
		add(botonRojo);
		
		add(botonVerde);*/
		
		AccionEventosMultiplesFuentes accionAmarillo = new AccionEventosMultiplesFuentes("Amarillo", new ImageIcon("src/graficos/amarillo.gif"), Color.yellow);
		
		AccionEventosMultiplesFuentes accionRojo = new AccionEventosMultiplesFuentes("Rojo", new ImageIcon("src/graficos/rojo.gif"), Color.red);
		
		AccionEventosMultiplesFuentes accionVerde = new AccionEventosMultiplesFuentes("Verde", new ImageIcon("src/graficos/verde.gif"),  Color.green);
		
		add(new JButton(accionAmarillo));
		
		add(new JButton(accionRojo));
		
		add(new JButton(accionVerde));
		
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondoAmarillo1");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl Y"), "fondoAmarillo2");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondoRojo1");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl E"), "fondoRojo2");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl V"), "fondoVerde1");
		
		mapaEntrada.put(KeyStroke.getKeyStroke("ctrl G"), "fondoVerde2");
		
		ActionMap mapaAccion = getActionMap();
		
		mapaAccion.put("fondoAmarillo1", accionAmarillo);
		
		mapaAccion.put("fondoAmarillo2", accionAmarillo);
		
		mapaAccion.put("fondoRojo1", accionRojo);
		
		mapaAccion.put("fondoRojo2", accionRojo);
		
		mapaAccion.put("fondoVerde1", accionVerde);
		
		mapaAccion.put("fondoVerde2", accionVerde);
		
	}
	
	private class AccionEventosMultiplesFuentes extends AbstractAction {
		
		public AccionEventosMultiplesFuentes(String nombre, Icon icono, Color color) {
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Hacer " + nombre.toLowerCase() + " el fondo");
			
			putValue("colorFondo", color);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			Color c = (Color)getValue("colorFondo");
			
			setBackground(c);
			
		}
		
	}
	
}
package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosMultiplesFuentes2 {

	public static void main(String[] args) {
		
		MarcoEventosMultiplesFuentes2 marco = new MarcoEventosMultiplesFuentes2();

	}

}

class MarcoEventosMultiplesFuentes2 extends JFrame {
	
	public MarcoEventosMultiplesFuentes2() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		
		Dimension dimensiones = pantalla.getScreenSize();
		
		int ancho = dimensiones.width;
		
		int alto = dimensiones.height;
		
		setSize(ancho/4, alto/4);
		
		setLocation(3*ancho/8, 3*alto/8);
		
		setTitle("Eventos multiples fuentes 2");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);
		
		setVisible(true);
		
		add(new LaminaEventosMultiplesFuentes2());
		
	}
	
}

class LaminaEventosMultiplesFuentes2 extends JPanel {
	
	public LaminaEventosMultiplesFuentes2() {
		
		AccionEventosMultiplesFuentes2 accion_rosa = new AccionEventosMultiplesFuentes2("Rosa", Color.PINK);
		
		AccionEventosMultiplesFuentes2 accion_azul = new AccionEventosMultiplesFuentes2("Azúl", Color.BLUE);
		
		AccionEventosMultiplesFuentes2 accion_blanco = new AccionEventosMultiplesFuentes2("Blanco", Color.WHITE);
		
		AccionEventosMultiplesFuentes2 accion_morado = new AccionEventosMultiplesFuentes2("Morado", Color.MAGENTA);
		
		add(new JButton(accion_rosa));
		
		add(new JButton(accion_azul));
		
		add(new JButton(accion_blanco));
		
		add(new JButton(accion_morado));
		
		KeyStroke teclas_rosa_1 = KeyStroke.getKeyStroke("ctrl R");
		
		KeyStroke teclas_rosa_2 = KeyStroke.getKeyStroke("ctrl P");
		
		KeyStroke teclas_azul_1 = KeyStroke.getKeyStroke("ctrl A");
		
		KeyStroke teclas_azul_2 = KeyStroke.getKeyStroke("ctrl L");
		
		KeyStroke teclas_blanco_1 = KeyStroke.getKeyStroke("ctrl B");
		
		KeyStroke teclas_blanco_2 = KeyStroke.getKeyStroke("ctrl W");
		
		KeyStroke teclas_morado_1 = KeyStroke.getKeyStroke("ctrl M");
		
		KeyStroke teclas_morado_2 = KeyStroke.getKeyStroke("ctrl U");
		
		InputMap mapa_entrada = getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		
		mapa_entrada.put(teclas_rosa_1, "kr1");
		
		mapa_entrada.put(teclas_rosa_2, "kr2");
		
		mapa_entrada.put(teclas_azul_1, "ka1");
		
		mapa_entrada.put(teclas_azul_2, "ka2");
		
		mapa_entrada.put(teclas_blanco_1, "kb1");
		
		mapa_entrada.put(teclas_blanco_2, "kb2");
		
		mapa_entrada.put(teclas_morado_1, "km1");
		
		mapa_entrada.put(teclas_morado_2, "km2");
		
		ActionMap mapa_accion = getActionMap();
		
		mapa_accion.put("kr1", accion_rosa);
		
		mapa_accion.put("kr2", accion_rosa);
		
		mapa_accion.put("ka1", accion_azul);
		
		mapa_accion.put("ka2", accion_azul);
		
		mapa_accion.put("kb1", accion_blanco);
		
		mapa_accion.put("kb2", accion_blanco);
		
		mapa_accion.put("km1", accion_morado);
		
		mapa_accion.put("km2", accion_morado);
		
	}
	
	private class AccionEventosMultiplesFuentes2 extends AbstractAction {
		
		public AccionEventosMultiplesFuentes2(String nombre, Color color) {
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SHORT_DESCRIPTION, "Pon el fondo de color " + nombre.toLowerCase());
			
			putValue("color_fondo", color);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			
			setBackground((Color)getValue("color_fondo"));
			
		}
		
	}
	
}
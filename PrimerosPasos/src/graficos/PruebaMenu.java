package graficos;

import javax.swing.*;

import java.awt.*;

public class PruebaMenu {

	public static void main(String[] args) {
		
		MarcoMenu marco = new MarcoMenu();
		
		marco.setVisible(true);

	}

}

class MarcoMenu extends JFrame {
	
	public MarcoMenu() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Menú");
		
		add(new LaminaMenu());
		
	}
	
}

class LaminaMenu extends JPanel {
	
	public LaminaMenu() {
		
		JMenuBar barra = new JMenuBar();
		
		JMenu archivo = new JMenu("Archivo");
		
		JMenu edicion = new JMenu("Edición");
		
		JMenu herramientas = new JMenu("Herramientas");
		
		JMenu opciones = new JMenu("Opciones");
		
		JMenuItem guardar = new JMenuItem("Guardar");
		
		JMenuItem guardarComo = new JMenuItem("Guardar como");
		
		JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("src/graficos/cortar.gif"));
		
		JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("src/graficos/copiar.gif"));
		
		JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/graficos/pegar.gif"));
		
		//pegar.setHorizontalTextPosition(SwingConstants.LEFT);
		
		JMenuItem generales = new JMenuItem("Generales");
		
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		
		opciones.add(opcion1);
		
		opciones.add(opcion2);
		
		archivo.add(guardar);
		
		archivo.add(guardarComo);
		
		edicion.add(copiar);
		
		edicion.add(cortar);
		
		edicion.add(pegar);
		
		edicion.addSeparator();
		
		edicion.add(opciones);
		
		herramientas.add(generales);
		
		barra.add(archivo);
		
		barra.add(edicion);
		
		barra.add(herramientas);
		
		add(barra);
		
	}
	
}

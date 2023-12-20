package graficos;

import java.awt.*;

import java.awt.Event.*;

import java.awt.event.*;

import javax.swing.*;


public class Barra_Herramientas {

	public static void main(String[] args) {
		
		Marco_Barra mimarco=new Marco_Barra();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Barra extends JFrame{
	
	public Marco_Barra(){
		
		setTitle("Marco con Barra");
		
		setBounds(500,300,600,450);
		
		lamina=new JPanel();
		
		add(lamina);
		
		// configuración de acciones
		
		Action accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/graficos/amarillo2.gif"), Color.YELLOW);
		
		Action accionVerde = new AccionColor("Verde", new ImageIcon("src/graficos/verde2.gif"), Color.GREEN);
		
		Action accionRojo = new AccionColor("Rojo", new ImageIcon("src/graficos/rojo2.gif"), Color.RED);
		
		Action accionSalir = new AbstractAction("Salir", new ImageIcon("src/graficos/salir.gif")) {
			
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
			
		};
		
		JMenu menu = new JMenu("Color");
		
		menu.add(accionAmarillo);
		
		menu.add(accionVerde);
		
		menu.add(accionRojo);
		
		JMenuBar barraMenu = new JMenuBar();
		
		barraMenu.add(menu);
		
		setJMenuBar(barraMenu); //Agrega el menú directamente al marco
		
		//Construcción de la barra de herramientas
		
		JToolBar barraHerramientas = new JToolBar();
		
		barraHerramientas.add(accionAmarillo);
		
		barraHerramientas.add(accionVerde);
		
		barraHerramientas.add(accionRojo);
		
		barraHerramientas.addSeparator();
		
		barraHerramientas.add(accionSalir);
		
		add(barraHerramientas, BorderLayout.NORTH); //Debe indicarse la zona del BorderLayout para que pueda arrastrarse
		
	}
		
	
	private class AccionColor extends AbstractAction{
		
		public AccionColor(String nombre, Icon icono, Color c){
			
			putValue(Action.NAME, nombre);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
			
			putValue("Color", c);
		}
		
		public void actionPerformed(ActionEvent arg0) {
			
			Color c=(Color) getValue("Color");
			
			lamina.setBackground(c);
			
		}		
		
	}
	
	private JPanel lamina;
	
}
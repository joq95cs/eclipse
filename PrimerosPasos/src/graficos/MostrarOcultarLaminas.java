package graficos;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class MostrarOcultarLaminas {

	public static void main(String[] args) {		
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				new MarcoMOL().setVisible(true);
				
			}
			
		});
		
	}

}

class MarcoMOL extends JFrame {
	
	public MarcoMOL() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mostrar y ocultar láminas");
		
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(w/4, h/4, w/2, h/2);
		
		int filas = new Random().nextInt(9) + 1;
		int columnas = new Random().nextInt(9) + 1;
		
		setLayout(new GridLayout(filas, columnas));
		
		System.out.println(filas +" "+ columnas);
		
		iniciarLaminas(filas, columnas);
		agregarLaminas();
		agregarEventos();
		
	}
	
	private void iniciarLaminas(int filas, int columnas) {
		
		laminas = new JPanel[filas * columnas];
		
		for(int i=0; i<laminas.length; i++) {
			
			laminas[i] = new JPanel();
			
			laminas[i].setBackground(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
			
		}
		
	}
	
	private void agregarLaminas() {
		
		for(JPanel e: laminas) {
			
			add(e);
			
		}
		
	}

	private void agregarEventos() {
		
		for(JPanel e: laminas) {
			
			e.addMouseListener(new OyenteMOL(e));
			
		}
		
	}

	private JPanel[] laminas;
	
	private class OyenteMOL extends MouseAdapter {
		
		public OyenteMOL(JPanel lamina) {
			
			this.lamina = lamina;
			mostrar = false;
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
			if(mostrar) {
				
				lamina.setBackground(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
				
				mostrar = false;
				
			} else {
				
				lamina.setBackground(new Color(255, 255, 255));
				
				mostrar = true;
				
			}
			
		}
		
		private boolean mostrar;
		private JPanel lamina;
		
	}
	
}
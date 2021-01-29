package graficos;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class EventosLista {

	public static void main(String[] args) {
		
		MarcoEL marco = new MarcoEL();
		
		marco.setVisible(true);

	}

}

class MarcoEL extends JFrame {
	
	public MarcoEL() {
		
		int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		setBounds(ancho/3, alto/3, ancho/3, alto/3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Eventos de lista");
		
		LaminaEL lamina = new LaminaEL();
		
		add(lamina);
		
	}
	
}

class LaminaEL extends JPanel {
	
	public LaminaEL() {
		
		setLayout(new BorderLayout());
		
		lamina_centro = new JPanel();
		
		lamina_centro.setLayout(new GridLayout(1, 2));
		
		lista = new JList<String>();
		
		scroll2 = new  JScrollPane(lista);
		
		lamina_centro.add(scroll2);
		
		area = new JTextArea("");
		
		area.setLineWrap(true);
		
		area.setEditable(false);
		
		scroll1 = new JScrollPane(area);
		
		lamina_centro.add(scroll1);
		
		add(lamina_centro, BorderLayout.CENTER);
		
		lamina_sur = new JPanel();
		
		lamina_sur.setLayout(new GridLayout(1, 2));
		
		OyenteEL1 oyente = new OyenteEL1();
		
		boton1 = new JButton("Fijar elementos de la lista");
		
		boton1.addActionListener(oyente);
		
		lamina_sur.add(boton1);
		
		boton2 = new JButton("Agregar elementos al área");
		
		boton2.addActionListener(oyente);
		
		lamina_sur.add(boton2);
		
		add(lamina_sur, BorderLayout.SOUTH);
		
	}
	
	private class OyenteEL1 implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == boton1) {
				
				String[] cadenas = new String[Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de cadenas a agregar"))];
				
				for(int i=0; i<cadenas.length; i++) {
					
					cadenas[i] = JOptionPane.showInputDialog("Ingrese cadena " + (i+1));
					
				}
				
				lista.setListData(cadenas);
				
			} else {
				
				Object[] cadenas = lista.getSelectedValues();
				
				String aux = "";
				
				for(int i=0; i<cadenas.length; i++) {
					
					aux += (String)cadenas[i] + "\n";
					
				}
				
				area.setText(area.getText() + aux);
				
			}
			
		}
		
	}
	
	private JButton boton1;
	
	private JButton boton2;
	
	private JList lista;
	
	private JTextArea area;
	
	private JScrollPane scroll1;
	
	private JScrollPane scroll2;
	
	private JPanel lamina_centro;
	
	private JPanel lamina_sur;
	
}

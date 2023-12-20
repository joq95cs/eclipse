package graficos;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Prueba_JList {

	public static void main(String[] args) {
		
		new MarcoJL().setVisible(true);

	}

}

class MarcoJL extends JFrame {
	
	public MarcoJL() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Prueba de JList");
		
		setSize(500, 350);
		
		setLocationRelativeTo(null);
		
		add(new LaminaJL());
		
	}
	
}

class LaminaJL extends JPanel {
	
	public LaminaJL() {
		
		setLayout(new BorderLayout());
		
		JList<String> lista = new JList<String>(new String[] {
				
				"Enero",
				"Febrero",
				"Marzo",
				"Abril",
				"Mayo",
				"Junio",
				"Julio",
				"Agosto",
				"Septiembre",
				"Octubre",
				"Noviembre",
				"Diciembre"
				
		});
		
		lista.setVisibleRowCount(5);
		
		JPanel l1 = new JPanel();
		
		l1.add(new JScrollPane(lista));
		
		add(l1, BorderLayout.NORTH);
		
		JLabel rotulo = new JLabel("Selección: ");
		
		JPanel l2 = new JPanel();
		
		l2.add(rotulo);
		
		add(l2, BorderLayout.SOUTH);
		
		lista.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				List<String> meses = lista.getSelectedValuesList();
				
				StringBuilder cadena = new StringBuilder("Selección: ");
				
				for(String a: meses) {
					
					cadena.append(a + " ");
					
				}
				
				rotulo.setText(cadena.toString());
				
			}
			
		});
		
		
		
	}
	
}
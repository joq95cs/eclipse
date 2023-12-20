package graficos;

import javax.swing.*;

public class MenuEmergente {

	public static void main(String[] args) {
		
		MarcoME m = new MarcoME();
		
		m.setVisible(true);
		
	}

}

class MarcoME extends JFrame {
	
	public MarcoME() {
		
		setSize(400, 300);
		
		setTitle("Men� emergente");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaME l = new LaminaME();
		
		add(l);
		
	}
	
}

class LaminaME extends JPanel {
	
	public LaminaME() {
		
		JPopupMenu menuEmergente = new JPopupMenu();
		
		JMenuItem opcion1 = new JMenuItem("Opci�n 1");
		
		JMenuItem opcion2 = new JMenuItem("Opci�n 2");
		
		JMenuItem opcion3 = new JMenuItem("Opci�n 3");
		
		menuEmergente.add(opcion1);
		
		menuEmergente.add(opcion2);
		
		menuEmergente.add(opcion3);
		
		setComponentPopupMenu(menuEmergente);
		
	}
	
}

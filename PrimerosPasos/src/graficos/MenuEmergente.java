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
		
		setTitle("Menú emergente");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LaminaME l = new LaminaME();
		
		add(l);
		
	}
	
}

class LaminaME extends JPanel {
	
	public LaminaME() {
		
		JPopupMenu menuEmergente = new JPopupMenu();
		
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		
		JMenuItem opcion3 = new JMenuItem("Opción 3");
		
		menuEmergente.add(opcion1);
		
		menuEmergente.add(opcion2);
		
		menuEmergente.add(opcion3);
		
		setComponentPopupMenu(menuEmergente);
		
	}
	
}

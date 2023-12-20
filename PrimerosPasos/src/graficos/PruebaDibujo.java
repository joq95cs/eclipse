package graficos;

import java.awt.*;

import javax.swing.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		
		MarcoConDibujos mimarco = new MarcoConDibujos();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConDibujos extends JFrame {
	
	public MarcoConDibujos() {
		
		setTitle("Prueba de Dibujo");
		
		setSize(400, 400);
		
		LaminaConFiguras milamina = new LaminaConFiguras();
		
		add(milamina);
		
	}
	
}

class LaminaConFiguras extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//g.drawRect(50, 50, 200, 200);
		
		//g.drawLine(100, 100, 300, 200);
		
		g.drawArc(50, 100, 100, 200, 120, 150);
		
	}
	
}

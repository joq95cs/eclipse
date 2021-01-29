package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;

public class PruebaDibujo2 {

	public static void main(String[] args) {
		
		MarcoConDibujos2 mimarco = new MarcoConDibujos2();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConDibujos2 extends JFrame {
	
	public MarcoConDibujos2() {
		
		setTitle("Prueba de Dibujo");
		
		setSize(400, 400);
		
		LaminaConFiguras2 milamina = new LaminaConFiguras2();
		
		add(milamina);
		
	}
	
}

class LaminaConFiguras2 extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//g.drawRect(50, 50, 200, 200);
		
		//g.drawLine(100, 100, 300, 200);
		
		//g.drawArc(50, 100, 100, 200, 120, 150);
		
		Graphics2D g2 = (Graphics2D) g; //Se convierte el objeto Graphics a Graphics2D
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150); //Polimorfismo, princicio de sustitución
				
		g2.draw(rectangulo);
		
	}
	
}

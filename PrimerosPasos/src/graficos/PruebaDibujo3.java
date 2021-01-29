package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;

public class PruebaDibujo3 {

	public static void main(String[] args) {
		
		MarcoConDibujos3 mimarco = new MarcoConDibujos3();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConDibujos3 extends JFrame {
	
	public MarcoConDibujos3() {
		
		setTitle("Prueba de Dibujo");
		
		setSize(400, 400);
		
		LaminaConFiguras3 milamina = new LaminaConFiguras3();
		
		add(milamina);
		
	}
	
}

class LaminaConFiguras3 extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//g.drawRect(50, 50, 200, 200);
		
		//g.drawLine(100, 100, 300, 200);
		
		//g.drawArc(50, 100, 100, 200, 120, 150);
		
		Graphics2D g2 = (Graphics2D) g; //Se convierte el objeto Graphics a Graphics2D
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150); //Polimorfismo, princicio de sustitución
				
		g2.draw(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		
		g2.draw(elipse);
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
		double centroEnX = rectangulo.getCenterX();
		
		double centroEnY = rectangulo.getCenterY();
		
		double radio = 150;
		
		Ellipse2D circulo = new Ellipse2D.Double();
		
		circulo.setFrameFromCenter(centroEnX, centroEnY, centroEnX+radio, centroEnY+radio);
		
		g2.draw(circulo);
		
	}
	
}

package graficos;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;

public class PruebaDibujo4 {

	public static void main(String[] args) {
		
		MarcoConDibujos4 mimarco = new MarcoConDibujos4();
		
		mimarco.setVisible(true);
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConDibujos4 extends JFrame {
	
	public MarcoConDibujos4() {
		
		setTitle("Prueba de Dibujo");
		
		setSize(400, 400);
		
		LaminaConFiguras4 milamina = new LaminaConFiguras4();
		
		add(milamina);
		
		// milamina.setBackground(SystemColor.window); //Se le da color al Frame acordo al SO
	
		milamina.setBackground(Color.PINK);
		
	}
	
}

class LaminaConFiguras4 extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g; //Se convierte el objeto Graphics a Graphics2D
		
		Color color_1 = new Color(234, 5, 98);
		
		Color color_2 = new Color(32, 67, 30);
		
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150); //Polimorfismo, princicio de sustitución
		
		g2.setPaint(color_1);
		
		g2.draw(rectangulo);
		
		g2.setPaint(color_2);
		
		g2.fill(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		
		g2.setPaint(Color.PINK);
		
		g2.draw(elipse);
		
		g2.setPaint(Color.GRAY);
		
		g2.fill(elipse);
		
	}
	
}

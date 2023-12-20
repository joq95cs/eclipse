package practica_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Lamina extends JPanel {
	
	public Lamina() {
		
		setLayout(null);
		
		setBackground(new Color(0, 128, 0));
		
		addMouseMotionListener(new Dibujar());
		
	}
	
	private class Dibujar implements MouseMotionListener {
		
		public void mouseDragged(MouseEvent e) {
			
			Graphics2D g = (Graphics2D) Lamina.this.getGraphics();
			
			g.setColor(Color.white);
			
			g.fill(new Ellipse2D.Double(e.getX(), e.getY(), 10, 10));
			
		}

		
		public void mouseMoved(MouseEvent arg0) {}
		
	}


}
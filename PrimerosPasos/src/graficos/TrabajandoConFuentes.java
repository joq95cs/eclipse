package graficos;

import javax.swing.*;

import java.awt.geom.*;

import java.awt.*;

public class TrabajandoConFuentes {

	public static void main(String[] args) {
		
		MarcoConFuentes mimarco = new MarcoConFuentes();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoConFuentes extends JFrame {
	
	public MarcoConFuentes() {
		
		this.setTitle("Prueba con fuentes");
		
		this.setSize(400, 400);
		
		LaminaConFuentes milamina = new LaminaConFuentes();
		
		add(milamina);
		
		milamina.setForeground(Color.CYAN.darker());
		
	}
	
}

class LaminaConFuentes extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Font mifuente = new Font("Times New Roman", Font.ITALIC, 26);
		
		g2.setFont(mifuente);
		
		//g2.setColor(Color.RED.darker());
		
		g2.drawString("Joqsan Adalid", 100, 100);
		
		g2.setFont(new Font("Arial", Font.BOLD, 14));
		
		//g2.setColor(new Color(234, 67, 90).brighter());
		
		g2.drawString("Castellanos Alicea", 100, 200);
		
	}
	
}
package graficos;

import java.awt.*;

import java.awt.geom.*;

import javax.swing.*;

public class MarcoCentradoConDibujos {

	public static void main(String[] args) {
		
		Ventana miVentana = new Ventana();
		
		Capa miCapa = new Capa();
		
		miVentana.setCapa(miCapa);
		
		miCapa.setAltoVentana(miVentana.getHeight());
		
		miCapa.setAnchoVentana(miVentana.getWidth());

	}

}

class Ventana extends JFrame {
	
	public Ventana() {
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamagno = miPantalla.getScreenSize();
		
		int ancho = tamagno.width;
		
		int alto = tamagno.height;
		
		setSize(ancho/2, alto/2);
		
		setLocation(ancho/4, alto/4);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("PRUEBA DE FUEGO");
		
		Image icono = miPantalla.getImage("src/graficos/icono_2.gif");
		
		setIconImage(icono);
		
		setResizable(false);
		
	}
	
	public void setCapa(Capa miCapa) {
		
		add(miCapa);
		
	}
	
}

class Capa extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		Graphics2D pincel = (Graphics2D) g;
		
		Rectangle2D rectangulo = new Rectangle2D.Double(anchoVentana/4, altoVentana/4, anchoVentana/2, altoVentana/2);
		
		pincel.setPaint(Color.GREEN);
		
		pincel.fill(rectangulo);
		
		Ellipse2D elipse = new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		
		pincel.setPaint(Color.PINK);
		
		pincel.fill(elipse);
		
		Ellipse2D circulo = new Ellipse2D.Double((anchoVentana/2)-50, (altoVentana/2)-50, 100, 100);
		
		pincel.setPaint(new Color(67, 65, 87));
		
		pincel.fill(circulo);
		
	}
	
	public void setAltoVentana(int altoVentana) {
		
		this.altoVentana = altoVentana;
		
	}
	
	public void setAnchoVentana(int anchoVentana) {
		
		this.anchoVentana = anchoVentana;
		
	}
	
	private int altoVentana;
	
	private int anchoVentana;
	
}
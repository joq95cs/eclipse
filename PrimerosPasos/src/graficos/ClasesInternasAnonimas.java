package graficos;

import javax.swing.*;

import java.awt.*;

public class ClasesInternasAnonimas {
	
	public static void main(String[] args) {
		
		MarcoCIA marco = new MarcoCIA();
		
		marco.setVisible(true);
		
	}
	
}

class MarcoCIA extends JFrame {
	
	public MarcoCIA() {
		
		Dimension dimensiones = new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width/3, Toolkit.getDefaultToolkit().getScreenSize().height/3);
		
		setSize(dimensiones);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new LaminaCIA("Rojo") {
			
			public void fijarColor() {
				
				setBackground(Color.YELLOW);
				
			}
			
		});
		
	}
	
}

class LaminaCIA extends JPanel {
	
	public LaminaCIA(String c) {
		
		color = c.toLowerCase();
		
		fijarColor();
		
	}
	
	public void fijarColor() {
		
		switch(color) {
		
		case "rojo":
			
			setBackground(Color.RED);
			
			break;
			
		case "verde":
			
			setBackground(Color.GREEN);
			
			break;
			
		case "azúl":
			
			setBackground(Color.BLUE);
			
			break;
			
		case "blanco":
			
			setBackground(Color.WHITE);
			
			break;
			
		case "negro":
			
			setBackground(Color.BLACK);
			
			break;
			
		case "amarillo":
			
			setBackground(Color.YELLOW);
			
			break;
			
		case "naranja":
			
			setBackground(Color.ORANGE);
			
			break;
			
		case "gris":
			
			setBackground(Color.GRAY);
			
			break;
			
		case "rosa":
			
			setBackground(Color.PINK);
			
			break;
			
		case "morado":
			
			setBackground(Color.MAGENTA);
			
			break;
 		
		}
		
	}

	private String color;
	
}
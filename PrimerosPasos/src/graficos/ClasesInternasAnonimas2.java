package graficos;

import java.awt.*;

import javax.swing.*;

public class ClasesInternasAnonimas2 {

	public static void main(String[] args) {
		
		MarcoCIA2 marco = new MarcoCIA2();
		
		marco.setVisible(true);

	}

}

class MarcoCIA2 extends JFrame {
	
	public MarcoCIA2() {
		
		Dimension dimensiones = new Dimension(400, 250);
		
		setSize(dimensiones);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel lamina = new JPanel() {
			
			public void setBackground(Color bg) {
				
				super.setBackground(Color.PINK);
				
			}
			
		};
		
		add(lamina);
		
		lamina.setBackground(Color.gray);
		
	}
	
}


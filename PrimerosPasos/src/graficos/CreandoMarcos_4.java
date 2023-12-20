package graficos;

import javax.swing.*;

public class CreandoMarcos_4 {

	public static void main(String[] args) {
		
		MiMarco_4 marco = new MiMarco_4();
		
		marco.setVisible(true);
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MiMarco_4 extends JFrame {
	
	public MiMarco_4() {
		
		setBounds(500, 300, 550, 250);
		
		setTitle("MI VENTANA");
		
	}
	
}

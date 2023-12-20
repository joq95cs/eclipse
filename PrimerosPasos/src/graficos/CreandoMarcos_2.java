package graficos;

import javax.swing.*;

public class CreandoMarcos_2 {
	
	public static void main(String[] args) {
		
		MiMarco_2 marco = new MiMarco_2();
		
	}

}

class MiMarco_2 extends JFrame{
	
	public MiMarco_2() {
		
		this.setSize(640, 480);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
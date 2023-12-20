package graficos;

import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos_3 {

	public static void main(String[] args) {
		
		MiMarco_3 marco = new MiMarco_3();
		
		marco.setVisible(true);
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MiMarco_3 extends JFrame {
	
	public MiMarco_3() {
		
		this.setBounds(500, 300, 250, 250); //Recibe x, y, ancho y alto.
		
		//X hacia la derecha, Y hacia abajo.
		
		//this.setResizable(false);
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		
	}
	
}

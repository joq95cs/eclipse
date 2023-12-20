package graficos;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		
		MiMarco marco1 = new MiMarco(); //Se abre por defecto en la esquina superior izquierda de la pantalla.
		
		marco1.setVisible(true);
		
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Constante de clase.
		
	}

}

class MiMarco extends JFrame {
	
	public MiMarco() {
		
		setSize(500, 300); //Fija tamaño del marco.
		
		setLocation(500, 300); //Establece la ubicación en coordenadas cartesianas. El punto (0,0) está en la esquina superior izquierda.
		
		//El punto elegido es la esquina superior izquierda del frame.
		
	}
	
}

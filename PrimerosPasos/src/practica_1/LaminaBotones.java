package practica_1;

import javax.swing.*;

public class LaminaBotones extends JPanel {
	
	public LaminaBotones(String titulo, String[] opciones) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo)); //Se fija el borde
		//Se crea un borde sencillo
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//Disposici�n Box Layout cuyos componentes estar�n dispuestos de arriba a abajo
		
		grupo = new ButtonGroup();
		
		for(int i=0; i<opciones.length; i++) {
			
			JRadioButton radio = new JRadioButton(opciones[i]);
			
			radio.setActionCommand(opciones[i]); //Se le da una acci�n de comando con el texto del bot�n
			
			add(radio); //Se agrega el bot�n a la l�mina
			
			grupo.add(radio); //Se agrega el bot�n al grupo
			
			radio.setSelected(i == 0); //Se selecciona si i es 0
			
		}
		
	}
	
	public String seleccion() {
		
		/*ButtonModel boton = grupo.getSelection(); //Devuelve el bot�n seleccionado en el grupo
		
		String nombre = boton.getActionCommand(); //Devuelve la acci�n de comando del bot�n
		
		return nombre;*/
		
		return grupo.getSelection().getActionCommand();
		
	}
	
	private ButtonGroup grupo;
	
}
package practica_1;

import javax.swing.*;

public class LaminaBotones extends JPanel {
	
	public LaminaBotones(String titulo, String[] opciones) {
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo)); //Se fija el borde
		//Se crea un borde sencillo
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//Disposición Box Layout cuyos componentes estarán dispuestos de arriba a abajo
		
		grupo = new ButtonGroup();
		
		for(int i=0; i<opciones.length; i++) {
			
			JRadioButton radio = new JRadioButton(opciones[i]);
			
			radio.setActionCommand(opciones[i]); //Se le da una acción de comando con el texto del botón
			
			add(radio); //Se agrega el botón a la lámina
			
			grupo.add(radio); //Se agrega el botón al grupo
			
			radio.setSelected(i == 0); //Se selecciona si i es 0
			
		}
		
	}
	
	public String seleccion() {
		
		/*ButtonModel boton = grupo.getSelection(); //Devuelve el botón seleccionado en el grupo
		
		String nombre = boton.getActionCommand(); //Devuelve la acción de comando del botón
		
		return nombre;*/
		
		return grupo.getSelection().getActionCommand();
		
	}
	
	private ButtonGroup grupo;
	
}
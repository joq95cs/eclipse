package castellanos.joqsan.PruebaGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import gui_hibernatecrud.Click;
import gui_hibernatecrud.Marco;

public class App {
	
    public static void main( String[] args ) {
    	
    	//Evento evento = new Evento();
    	//Marco.m.setClick(evento);
    	
    	Marco.m.getBoton("Insertar").addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("Nana");
			}
    	});
    	
    	Marco.main(null);
    }
}

class Evento implements Click {

	@Override
	public void click(ActionEvent e) {
		
		if(e.getSource() == Marco.m.getBoton("Insertar")) {
			
			System.out.println("Se ha insertado");
			
		} else if(e.getSource() == Marco.m.getBoton("Actualizar")) {
			
			System.out.println("Se ha actualizado");
			
		} else if(e.getSource() == Marco.m.getBoton("Eliminar")) {
			
			System.out.println("Se ha eliminado");
			
		} else {
			
			System.out.println("Se ha buscado");
		}
	}
}
package castellanos.joqsan.HibernateCRUD;

import gui_hibernatecrud.Marco;

public class App {
	
    public static void main( String[] args ) throws Exception {
    	
    	Oyente oyente = new Oyente();
 
    	Marco.m.iniciar();
    	Marco.m.btInsertar.addActionListener(oyente);
    	Marco.m.btActualizar.addActionListener(oyente);
    	Marco.m.btBuscar.addActionListener(oyente);
    	Marco.m.btEliminar.addActionListener(oyente);
    	
    	Marco.main(null);
    }
}

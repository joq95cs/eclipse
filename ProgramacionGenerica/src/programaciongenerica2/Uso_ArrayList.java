package programaciongenerica2;

import java.io.*;

public class Uso_ArrayList {

	public static void main(String[] args) {
		
		ArrayList datos = new ArrayList(4);
		
		datos.add("Joqsan");
		
		datos.add("Jader");
		
		datos.add("Soanny");
		
		datos.add(new File(""));
		
		String nombrePersona = (String)datos.get(3); //Se debe hacer un casting
		
		//File archivo = (File)datos.get(0);
		
		System.out.println(nombrePersona);

	}

}

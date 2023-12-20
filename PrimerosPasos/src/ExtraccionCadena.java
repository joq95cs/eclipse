
public class ExtraccionCadena {

	public static void main(String[] args) {
		
		String cadena = "joqlers_95_cs@hotmail.com";
		
		String cadena_aux = "";
		
		for(int i=0; i<cadena.length(); i++) {
			
			if(cadena.charAt(i) != '@' && cadena.charAt(i) != '.' && cadena.charAt(i) != ' ' && cadena.charAt(i) != '-' && cadena.charAt(i) != '_' && cadena.charAt(i) != '0' && cadena.charAt(i) != '1' && cadena.charAt(i) != '2' && cadena.charAt(i) != '3' && cadena.charAt(i) != '4' && cadena.charAt(i) != '5' && cadena.charAt(i) != '6' && cadena.charAt(i) != '7' && cadena.charAt(i) != '8' && cadena.charAt(i) != '9') {
				
				cadena_aux += cadena.charAt(i);
				
			}
			
		}
		
		System.out.println(cadena_aux);

	}

}

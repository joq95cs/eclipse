
public class ComprobarMayusculasString {

	public static void main(String[] args) {
		
		String cadena = "joqsan";
		
		boolean contiene_mayusculas = false;
		
		String aux1 = null;
		
		String aux2 = null;
		
		for(int i=0; i<cadena.length(); i++) {
			
			aux1 = "" + cadena.charAt(i);
			
			aux2 = aux1.toUpperCase();
			
			if(aux1.equals(aux2)) {
				
				contiene_mayusculas = true;
				
			}
			
		}
		
		if(contiene_mayusculas) {
			
			System.out.println("CONTIENE MAYÚSCULAS");
			
		}
		
		else {
			
			System.out.println("NO CONTIENE MAYÚSCULAS");
			
		}

	}

}

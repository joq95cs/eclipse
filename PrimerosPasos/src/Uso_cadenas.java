
public class Uso_cadenas {

	public static void main(String[] args) {

		String nombre="Joqsan Adalid Castellanos Alicea";
		
		System.out.println("Mi nombre es: "+nombre);
		
		System.out.println("Mi nombre tiene: "+nombre.length()+" caracteres");
		
		System.out.println("La primera letra de mi nombre es: "+nombre.charAt(0));
		
		byte ultima_letra=(byte)nombre.length();
		
		System.out.println("La última letra de mi nombre es: "+nombre.charAt(ultima_letra-1));
		
		System.out.println("Mi primer nombre es: "+nombre.substring(0,6));
		
	}

}

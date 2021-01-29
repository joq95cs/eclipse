
public class Array_char {

	public static void main(String[] args) {
		
		char[] nombre = {'J', 'o', 'q', 's', 'a', 'n', ' ', 'A', 'd', 'a', 'l', 'i', 'd', ' ', 'C', 'a', 's', 't', 'e', 'l', 'l', 'a', 'n', 'o', 's', ' ', 'A', 'l', 'i', 'c', 'e', 'a'};
		
		String mi_nombre = "";
		
		for(int i=0; i<nombre.length; i++) {
			
			mi_nombre += nombre[i];
			
		}
		
		System.out.println("Mi nombre: " + mi_nombre);
		
	}

}

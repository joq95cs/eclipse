
public class Uso_cadenas_2 {

	public static void main(String[] args) {
		
		String frase="Es como una canci�n que llega al coraz�n... escuchala y sabr�s"
				+ " cuan fuerte cantar�s.";
		
		int numero_caracteres=frase.length();
		
		String frase_extraida=frase.substring(44,numero_caracteres)+"\n-David Archuleta-";
		
		String frase_extraida1=frase.substring(0,44);
		
		System.out.println(frase_extraida1+frase_extraida);
		
	}

}

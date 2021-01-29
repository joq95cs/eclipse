import java.util.*;

public class Tipos_enumerados {
	
	enum Continentes {
		
		ASIA("Países: 48\nPoblación: 4,330,000\nCiudad más poblada: Tokio"),
		
		ÁFRICA("Países: 54\nPoblación: 1,000,000,000 aproximadamente\nCiudad más poblada: Johannesburgo"),
		
		AMÉRICA("Paises: 35\nPoblación: 1,041,034,000\nCiudad más poblada: Ciudad de México"),
		
		EUROPA("Países: 50\nPoblación: 739,000,000\nCiudad más poblada: Estambul"),
		
		OCEANÍA("Países: 14\nPoblación: 38,889,988\nCiudad más poblada: Sidney"),
		
		ANTÁRTIDA("Países: 0\nPoblación: 1,000 - 4,000 (temporalmente)");
		
		private Continentes(String continente) {
			
			this.continente = continente;
			
		}
		
		public String getInfo() {
			
			return continente;
			
		}
		
		private String continente;
		
	}

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		String continente_ingresado;
		
		System.out.print("Ingrese el nombre de un continente: ");
		
		continente_ingresado = entrada.nextLine().toUpperCase();
		
		Continentes continente_elegido = Enum.valueOf(Continentes.class,continente_ingresado);
		
		System.out.print("\n\n" + continente_elegido.getInfo());
		
		entrada.close();
		
	}

}
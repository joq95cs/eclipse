import java.util.*;

public class Tipos_enumerados {
	
	enum Continentes {
		
		ASIA("Pa�ses: 48\nPoblaci�n: 4,330,000\nCiudad m�s poblada: Tokio"),
		
		AFRICA("Pa�ses: 54\nPoblaci�n: 1,000,000,000 aproximadamente\nCiudad m�s poblada: Johannesburgo"),
		
		AMERICA("Paises: 35\nPoblaci�n: 1,041,034,000\nCiudad m�s poblada: Ciudad de M�xico"),
		
		EUROPA("Pa�ses: 50\nPoblaci�n: 739,000,000\nCiudad m�s poblada: Estambul"),
		
		OCEANIA("Pa�ses: 14\nPoblaci�n: 38,889,988\nCiudad m�s poblada: Sidney"),
		
		ANTARTIDA("Pa�ses: 0\nPoblaci�n: 1,000 - 4,000 (temporalmente)");
		
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
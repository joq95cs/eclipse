package poo;

public class IntanciacionEnMetodos {

	public static void main(String[] args) {
		
		CadenaTV cadena1 = new CadenaTV("Toei", "Japonés", "Japón");
		
		System.out.println(cadena1.dimePrograma(new Anime("DB", 153, "Shonen", "Toei")));

	}

}

class Anime {
	
	public Anime(String nombre, int no_capitulos, String genero, String cadena) {
		
		this.nombre = nombre;
		
		this.no_capitulos = no_capitulos;
		
		this.genero = genero;
		
		this.cadena = cadena;
		
	}
	
	public String getCadena() {
		
		return cadena;
		
	}
	
	public String getNombre() {
		
		return nombre;
		
	}
	
	public int getNoCapitulos () {
		
		return no_capitulos;
		
	}
	
	public String getGenero() {
		
		return genero;
		
	}
	
	private String nombre;
	
	private int no_capitulos;
	
	private String genero;
	
	private String cadena;
	
}

class CadenaTV {
	
	public CadenaTV(String nombre, String idioma, String pais) {
		
		this.nombre = nombre;
		
		this.idioma = idioma;
		
		this.pais = pais;
		
	}
	
	public String dimePrograma(Anime programa) {
		
		if(programa.getCadena().equals(this.nombre)) {
			
			return "Nombre: " + programa.getNombre() + "\nNo. capitulos: " + programa.getNoCapitulos() + "\nGénero: " + programa.getGenero() + "\nCadena: " + programa.getCadena();
			
		}
		
		return "El programa no pertenece a la cadena";
		
	}
	
	private String nombre;
	
	private String idioma;
	
	private String pais;
	
}

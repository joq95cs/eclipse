package poo;

public class Método_toString {

	public static void main(String[] args) {
		
		Pelicula[] peliculas = new Pelicula[3];
		
		peliculas[0] = new Pelicula("Titanic", "Drama");
		
		peliculas[1] = new Pelicula("Avengers", "Acción");
		
		peliculas[2] = new Pelicula("Thor", "Acción");
		
		/*for(Pelicula e: peliculas) {
			
			e.setNombre("Iron Man");
			
		}*/
		
		for(Pelicula e: peliculas) {
			
			System.out.println(e);
			
		}

	}

}

class Pelicula {
	
	public Pelicula(String nombre, String genero) {
		
		this.nombre = nombre;
		
		this.genero = genero;
		
	}
	
	/*public String getNombre() {
		
		return nombre;
		
	}*/
	
	public String toString() {
		
		//return "No has llamado método para imprimir";
		
		return nombre + ": " + genero;
		
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	private String nombre, genero;
	
}

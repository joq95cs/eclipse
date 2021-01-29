package programaciongenerica3;

public class Uso_Pareja {

	public static void main(String[] args) {
		
		Pareja <String> objetoPareja1 = new Pareja <String>();
		
		objetoPareja1.setCampo1("Bulma");
		
		System.out.println(objetoPareja1.getCampo1());
		
		Persona persona1 = new Persona("Vegeta");
		
		Pareja <Persona> objetoPareja2 = new Pareja <Persona> ();
		
		objetoPareja2.setCampo1(persona1);
		
		System.out.println(objetoPareja2.getCampo1());
		
	}

}

class Persona {
	
	public Persona(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public String toString() { //Sobreescribiendo el método toString
		
		return nombre;
		
	}
	
	/*public String getNombre() {
		
		return nombre;
		
	}*/
	
	private String nombre;
	
}

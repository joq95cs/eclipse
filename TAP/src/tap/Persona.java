package tap;

public class Persona {
	
	public void setDatos(String n, String s, int e) {
		
		nombre = n;
		
		sexo = s;
		
		edad = e;
		
	}
	
	public void getDatos() {
		
		System.out.println("Nombre: " + nombre + "\nSexo: " + sexo + "\nEdad: " + edad);
		
	}
	
	public String getDatosG() {
		
		return "Nombre: " + nombre + "\nSexo: " + sexo + "\nEdad: " + edad + "\n\n";
		
	}
	
	private String nombre;
	
	private String sexo;
	
	private int edad;
	
}

package programaciongenerica3;

public class Empleado {
	
	public Empleado(String nombre, int edad, double salario) {
		
		this.nombre = nombre;
		
		this.edad = edad;
		
		this.salario = salario;
		
	}
	
	public String getDatos() {
		
		return "Nombre: " + nombre + "\nEdad: " + edad + "\nSalario: " + salario;
		
	}
	
	private String nombre;
	
	private int edad;
	
	private double salario;

}

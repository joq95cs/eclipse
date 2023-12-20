package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_persona {

	public static void main(String[] args) {
		
		Persona[] las_personas = new Persona[2];
		
		las_personas[0] = new Empleado_2("Gilberto Ferrer", 25000, 2011, 10, 5); //Polimorfismo
		
		las_personas[1] = new Alumno("Teresa Aguilar", "ISC"); //Polimorfismo
		
		for(Persona e: las_personas) {
			
			System.out.println(e.dameNombre() + "\n" + e.dameDescripcion() + "\n");
			
		}
		
	}

}

abstract class Persona {
	
	public Persona(String nom) {
		
		nombre = nom;
	}
	
	public String dameNombre() {
		
		return "Nombre: " + nombre;
		
	}
	
	public abstract String dameDescripcion();
	
	private String nombre;
	
}

class Empleado_2 extends Persona {
	
	public Empleado_2(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom);
		
		sueldo = sue;
		
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
		
		altaContrato = calendario.getTime();
		
		id = idSiguiente;
		
		idSiguiente++;
		
	}
	
	public String dameDescripcion() {
		
		return "ID: " + id +  "\nSueldo: " + sueldo;
		
	}
	
	public double dameSueldo() { //GETTER
		
		return sueldo;
		
	}
	
	public Date dameAltaContrato() { //GETTER
		
		return altaContrato;
		
	}
	
	public int dameID() {
		
		return id;
		
	}
	
	public void subeSueldo(double porcentaje) { //SETTER
		
		double aumento = sueldo * porcentaje / 100;
		
		sueldo += aumento;
		
	}
	
	private double sueldo;
	
	private Date altaContrato;
	
	private int id;
	
	private static int idSiguiente = 1;
	
}

class Alumno extends Persona {
	
	public Alumno(String nom, String car) {
		
		super(nom);
		
		carrera = car;
		
	}
	
	public String dameDescripcion() {
		
		return "Carrera: " + carrera;
		
	}
	
	private String carrera;
	
}

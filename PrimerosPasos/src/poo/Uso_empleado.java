package poo;

import java.util.*;

public class Uso_empleado {

	public static void main(String[] args) {
		
		/* Empleado empleado1 = new Empleado("Ángel Cruz", 25000, 2016, 11, 5);
		
		Empleado empleado2 = new Empleado("Eduardo Contreras", 34000, 2026, 2, 23);
		
		Empleado empleado3 = new Empleado("Jonas Maldonado", 22000, 2011, 6, 30);
		
		empleado1.subeSueldo(5);
		
		empleado2.subeSueldo(10);
		
		empleado3.subeSueldo(15);
		
		System.out.println("Nombre: " + empleado1.dameNombre() + "\nSueldo: " + empleado1.dameSueldo() 
				+ "\nFecha de alta: " + empleado1.dameAltaContrato());
		
		System.out.println("\nNombre: " + empleado2.dameNombre() + "\nSueldo: " + empleado2.dameSueldo() 
				+ "\nFecha de alta: " + empleado2.dameAltaContrato()); 
		
		System.out.println("\nNombre: " + empleado3.dameNombre() + "\nSueldo: " + empleado3.dameSueldo() 
				+ "\nFecha de alta: " + empleado3.dameAltaContrato()); */
		
		Jefe jefeVentas = new Jefe("Joqsan Castellanos", 55000, 2015, 5, 4);
		
		jefeVentas.estableceIncentivo(2570);
		
		Empleado[] mis_empleados = new Empleado[6];
		
		mis_empleados[0] = new Empleado("Ángel Cruz", 25000, 2016, 11, 5);
		
		mis_empleados[1] = new Empleado("Eduardo Contreras", 34000, 2016, 2, 23);
		
		mis_empleados[2] = new Empleado("Jonas Maldonado", 22000, 2011, 6, 30);
		
		mis_empleados[3] = new Empleado("Brian Reyes");
		
		mis_empleados[4] = jefeVentas; //Polimorfismo. Principio de sustitución.
		
		mis_empleados[5] = new Jefe("Brenda Raya", 40000, 2016, 5, 1);
		
		Jefe jefe_admon = (Jefe)mis_empleados[5];
		
		jefe_admon.estableceIncentivo(5000);
		
		/* for(int i=0; i<3; i++) {
			
			mis_empleados[i].subeSueldo(5);
			
		} */
		
		/* Empleado jefe_finanzas = new Jefe("Brian Reyes", 32000, 2009, 6, 6);
		
		Comparable ejemplo = new Empleado("David Pacheco", 10000, 2003, 9, 9);
		
		if(jefe_finanzas instanceof Empleado) {
			
			System.out.println("Es tipo Jefe");
			
		}
		
		if(ejemplo instanceof Comparable) {
			
			System.out.println("Implementa la interfaz comparable");
			
		} */
		
		System.out.println(jefe_admon.tomarDecisiones("Dar más días de vacaciones a los empleados\n"));
		
		System.out.println("El jefe " + jefe_admon.dameNombre() + " tiene un bono de " + jefe_admon.estableceBono(2400) + "\n");
		
		System.out.println("El empleado " + mis_empleados[3].dameNombre() + " tiene un bono de " + mis_empleados[3].estableceBono(1900) + "\n");
		
		for(Empleado e: mis_empleados) {
			
			e.subeSueldo(5);
			
		}
		
		/* for(int i=0; i<3; i++) {
			
			System.out.println("Nombre: " + mis_empleados[i].dameNombre()
								+ "\nSueldo: " + mis_empleados[i].dameSueldo()
								+ "\nFecha de alta: " + mis_empleados[i].dameAltaContrato() + "\n");
			
		}

	} */
		
		Arrays.sort(mis_empleados);
		
		for(Empleado e: mis_empleados) {
			
			System.out.println("Nombre: " + e.dameNombre()
					+ "\nSueldo: " + e.dameSueldo()
					+ "\nFecha de alta: " + e.dameAltaContrato()
					+ "\nID: " + e.dameID() + "\n");
			
		}
		
	}
	
}

class Empleado implements Comparable, Trabajadores {
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		
		nombre = nom;
		
		sueldo = sue;
		
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);
		
		altaContrato = calendario.getTime();
		
		id = idSiguiente;
		
		idSiguiente++;
		
	}
	
	public Empleado(String nom) {
		
		this(nom, 15000, 2000, 1, 1); //Llama al otro constructor
		
	}
	
	public String dameNombre() { //GETTER
		
		return nombre;
		
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
	
	public int compareTo(Object miObjeto) { //Se sobreescribe método de la interfaz
		
		Empleado otroEmpleado = (Empleado)miObjeto;
		
		if(this.id<otroEmpleado.id) {
			
			return -1;
			
		}
		
		if(this.id>otroEmpleado.id) {
			
			return 1;
			
		}
		
		return 0;
		
	}
	
	public double estableceBono(double gratificacion) {
		
		return Trabajadores.bono_base + gratificacion;
		
	}
	
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
	
	private int id;
	
	private static int idSiguiente = 1;
	
}

class Jefe extends Empleado implements Jefes {
	
	public Jefe(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom, sue, agno, mes, dia);
		
	}
	
	public void estableceIncentivo(double incentivo) {
		
		this.incentivo = incentivo;
		
	}
	
	public  double dameSueldo() {
		
		double sueldoJefe = super.dameSueldo();
		
		return sueldoJefe + incentivo;
		
	}
	
	public String tomarDecisiones(String decision) {
		
		return "Un miembro de la dirección ha tomado la decision de: " + decision;
		
	}
	
	public double estableceBono(double gratificacion) {
		
		double prima = 2000;
		
		return Trabajadores.bono_base + gratificacion + prima;
		
	}
	
	private double incentivo;
	
}

final class Director extends Jefe {
	
	public Director(String nom, double sue, int agno, int mes, int dia) {
		
		super(nom, sue, agno, mes, dia);
		
	}
	
}
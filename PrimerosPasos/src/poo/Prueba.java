package poo;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Empleados trabajador1 = new Empleados("Lalo");
		
		Empleados trabajador2 = new Empleados("Jonas");
		
		Empleados trabajador3 = new Empleados("Ángel");
		
		trabajador1.cambiaSeccion("Ventas");
		
		System.out.println(trabajador1.devuelveDatos() + "\n\n" + trabajador2.devuelveDatos() 
				+ "\n\n" + trabajador3.devuelveDatos());
		
		System.out.println("\n" + Empleados.dameIdsig());
		
	}

}

class Empleados {
	
	public Empleados(String nom) {
		
		nombre = nom;
		
		seccion = "Administración";
		
		id = idSig;
		
		idSig++;
		
		
	}
	
	public void cambiaSeccion(String seccion) { //SETTER
		
		this.seccion = seccion;
		
	}
	
	public String devuelveDatos() { //GETTER
		
		return "Nombre: " + nombre + "\nSección: " + seccion + "\nID: " + id;
		
	}
	
	public static String dameIdsig() {
		
		return "El ID siguiente es: " + idSig;		
	}
	
	private final String nombre;
	
	private String seccion;
	
	private int id;
	
	private static int idSig = 1;
	
}
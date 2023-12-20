package introspeccion;

public class UsoEmpleado {

	public static void main(String[] args) {
		
		Persona p1 = new Persona("Joqsan");
		
		System.out.println(p1.getNombre());
		
		Empleado e1 = new Empleado("Jonas", 35000);
		
		System.out.println(e1.getNombre());
		
		System.out.println(e1.getSalario());
		
		//System.out.println(p1.getClass());
		
		//Class cl1 = p1.getClass();
		
		//System.out.println(cl1.getName());
		
		try {
			
			Class cl1;
			
			String nombreClase = "introspeccion.Persona";
			
			cl1 = Class.forName(nombreClase);
			
			System.out.println(cl1.getName());
			
			nombreClase = "introspeccion.Empleado";
			
			cl1 = Class.forName(nombreClase);
			
			System.out.println(cl1.getName());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}

class Persona {
	
	public Persona(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public String getNombre() {
		
		return "Nombre: " + nombre;
		
	}
	
	private String nombre;
	
}

class Empleado extends Persona {

	public Empleado(String nombre, double salario) {
		
		super(nombre);
		
		this.salario = salario;
		
	}
	
	public void setIncentivo(double incentivo) {
		
		salario += incentivo;
		
	}
	
	public String getSalario() {
		
		return "Salario: " + salario;
		
	}
	
	private double salario;
	
}
package programaciongenerica3;

public class HerenciaGenerica {
	
	public static void main(String[] args) {
		
		Pareja<Empleado> p1 = new Pareja<Empleado>();
		
		Pareja<Jefe> p2 = new Pareja<Jefe>();
		
		Pareja.imprimirTrabajador(p1);
		
		Pareja.imprimirTrabajador(p2);
		
	}

}


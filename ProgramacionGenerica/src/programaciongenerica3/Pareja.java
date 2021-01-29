package programaciongenerica3;

public class Pareja <T> { //Suele usarse T, U y K
	
	public Pareja() {
		
		campo1 = null;
		
	}
	
	public void setCampo1(T valor) {
		
		campo1 = valor;
		
	}
	
	public T getCampo1() {
		
		return campo1;
		
	}
	
	public static void imprimirTrabajador(Pareja<? extends Empleado> p) { //Se le indica al método que puede recibir un Empleado o cualquier subclase de Empleado
		
		System.out.println(p.getCampo1());
		
	}
	
	private T campo1;

}

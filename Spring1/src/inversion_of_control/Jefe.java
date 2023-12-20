package inversion_of_control;

public class Jefe implements Empleados {

	public Jefe(CreacionInformes informe) {
		
		this.informe = informe;
	}
	
	public String getTareas() {
		
		return "Yo gestiono mi departamento";
	}

	@Override
	public String getInforme() {
		
		return "Informe creado por el jefe: " + informe.getInforme();
	}
	
	private CreacionInformes informe;
}
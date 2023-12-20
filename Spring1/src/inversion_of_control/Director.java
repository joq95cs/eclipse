package inversion_of_control;

public class Director implements Empleados {
	
	//Inyección de dependencia
	public Director(CreacionInformes informe) {
		
		this.informe = informe;
	}

	@Override
	public String getTareas() {
		
		return "Gestionar empresa";
	}

	@Override
	public String getInforme() {
		
		return "Informe creado por el director: " + informe.getInforme();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	//Método init, ejecutar antes de que el bean esté disponible
	public void metodoInicial() {
		
		System.out.println("Dentro del método init...");
	}
	
	//Método destroy, ejecutar después de que el bean fue usado
	public void metodoFinal() {
		
		System.out.println("Dentro del método destroy...");
	}
	
	private CreacionInformes informe; //Interfaz para crear reportes
	private String email;
	private String nombreEmpresa;
}
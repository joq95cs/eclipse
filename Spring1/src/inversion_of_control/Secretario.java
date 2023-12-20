package inversion_of_control;

public class Secretario implements Empleados {
	
	public String getTareas() {
		
		return "Gestionar agendas";
	}

	@Override
	public String getInforme() {
		
		return "Informe creado por el secretario: " + informe.getInforme();
	}
	
	public void setInforme(CreacionInformes informe) { //Inyección de dependencia
		
		this.informe = informe;
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

	private CreacionInformes informe;
	private String email;
	private String nombreEmpresa;
}

package spring_annotations;

import org.springframework.beans.factory.annotation.Value;

public class DirectorFinanciero implements Empleados {
	
	public DirectorFinanciero(CreacionInformeFinanciero nuevoInforme) {
		
		this.nuevoInforme = nuevoInforme;
	}

	public String getEmail() {
		return email;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Gestión de las operaciones financieras de la empresa...";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return nuevoInforme.getInformeFinanciero();
	}
	
	private CreacionInformeFinanciero nuevoInforme;
	
	@Value("${email}")
	private String email;
	
	@Value("${nombre}")
	private String nombreEmpresa;
}
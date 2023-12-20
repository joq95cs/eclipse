package spring_annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

//Se registra automáticamente el bean
//@Component("Vendedor")
@Component
@Scope("singleton")
public class Vendedor implements Empleados {

	/*@Autowired
	public Vendedor(CreacionInformeFinanciero nuevoInforme) { //Inyección de dependencia
		
		this.nuevoInforme = nuevoInforme;
	}
	
	*/
	
	/*@Autowired
	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}
	*/
	
	//Ejecución de código después de creación del bean
	@PostConstruct
	private void despuesCreacion() {
		
		System.out.println("Ejecutado tras creación de bean");
	}
	
	//Ejecución de código después de que se apagó el contenedor
	@PreDestroy
	private void antesDestruccion() {
		
		System.out.println("Ejecutado antes de la destrucción");
	}
	
	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender mucho...";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		//return "Esto es un informe generado por el vendedor...";
		return nuevoInforme.getInformeFinanciero();
	}
	
	@Autowired //Reflexión
	@Qualifier("informeFinanciero2") //Bean que se debe susar
	private CreacionInformeFinanciero nuevoInforme;
}
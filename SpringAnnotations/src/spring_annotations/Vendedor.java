package spring_annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

//Se registra autom�ticamente el bean
//@Component("Vendedor")
@Component
@Scope("singleton")
public class Vendedor implements Empleados {

	/*@Autowired
	public Vendedor(CreacionInformeFinanciero nuevoInforme) { //Inyecci�n de dependencia
		
		this.nuevoInforme = nuevoInforme;
	}
	
	*/
	
	/*@Autowired
	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
		this.nuevoInforme = nuevoInforme;
	}
	*/
	
	//Ejecuci�n de c�digo despu�s de creaci�n del bean
	@PostConstruct
	private void despuesCreacion() {
		
		System.out.println("Ejecutado tras creaci�n de bean");
	}
	
	//Ejecuci�n de c�digo despu�s de que se apag� el contenedor
	@PreDestroy
	private void antesDestruccion() {
		
		System.out.println("Ejecutado antes de la destrucci�n");
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
	
	@Autowired //Reflexi�n
	@Qualifier("informeFinanciero2") //Bean que se debe susar
	private CreacionInformeFinanciero nuevoInforme;
}
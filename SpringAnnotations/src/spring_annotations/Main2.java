package spring_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

	public static void main(String[] args) {

		//ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Config.class);
		
		/*Empleados e1 = contexto.getBean("vendedor", Empleados.class);
		Empleados e2 = contexto.getBean("vendedor", Empleados.class);
		
		if(e1 == e2) {
			
			System.out.println("Iguales");
			
		} else {
			
			System.out.println("Diferentes");
		}
		*/
		
		/*Empleados  e1 = contexto.getBean("getDirectorFinanciero", Empleados.class);
		
		System.out.println(e1.getTareas());
		System.out.println(e1.getInforme());
		*/
		
		DirectorFinanciero director = contexto.getBean("getDirectorFinanciero", DirectorFinanciero.class);
		
		System.out.println("Email del director: " + director.getEmail());
		System.out.println("Nombre de la empresa: " + director.getNombreEmpresa());
		
		contexto.close();
	}
}
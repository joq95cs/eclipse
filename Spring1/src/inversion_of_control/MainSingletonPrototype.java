package inversion_of_control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSingletonPrototype {
	
	public static void main(String[] args) {
		
		//Carga de XML de configuración
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("ApplicationContext2.xml");
		
		//Petición de beans al contenedor Spring
		
		Secretario secretario1 = contexto.getBean("Secretario", Secretario.class);
		Secretario secretario2 = contexto.getBean("Secretario", Secretario.class);
		Secretario secretario3 = contexto.getBean("Secretario", Secretario.class);
		Secretario secretario4 = contexto.getBean("Secretario", Secretario.class);
		
		System.out.println(secretario1);
		System.out.println(secretario2);
		System.out.println(secretario3);
		System.out.println(secretario4);
	}
}
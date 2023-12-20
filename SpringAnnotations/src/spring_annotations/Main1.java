package spring_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Leer archivo de configuración
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//Pedir bean al contenedor
		Empleados e1 = contexto.getBean("vendedor", Empleados.class);
		
		//Usar el bean
		System.out.println(e1.getInforme());
		System.out.println(e1.getTareas());
		
		contexto.close();
	}
}
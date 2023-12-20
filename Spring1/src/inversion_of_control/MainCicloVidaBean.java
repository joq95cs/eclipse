package inversion_of_control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCicloVidaBean {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("ApplicationContext3.xml");
		
		//Obtención del Bean
		Empleados empleado = contexto.getBean("Empleado", Empleados.class);
		System.out.println(empleado.getInforme());
		
		//Cerrar contexto
		contexto.close();
	}
}
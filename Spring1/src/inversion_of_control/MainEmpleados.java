package inversion_of_control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEmpleados {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		//Empleados empleado1 = contexto.getBean("Empleado", Empleados.class);
		/*Secretario empleado1 = contexto.getBean("Secretario", Secretario.class);
		System.out.println(empleado1.getTareas());
		System.out.println(empleado1.getInforme());
		System.out.println("Email: " + empleado1.getEmail());
		System.out.println("Empresa: " + empleado1.getNombreEmpresa());
		
		Secretario empleado2 = contexto.getBean("Secretario", Secretario.class);
		System.out.println(empleado2.getEmail());
		*/
		
		Director empleado1 = contexto.getBean("Empleado", Director.class);
		System.out.println(empleado1.getTareas());
		System.out.println(empleado1.getInforme());
		System.out.println("Email: " + empleado1.getEmail());
		System.out.println("Empresa: " + empleado1.getNombreEmpresa());
		
		contexto.close();
	}
}
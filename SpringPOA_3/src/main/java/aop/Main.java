package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aop.dao.ClienteDAO;
import aop.dao.ClienteEspecialDAO;

public class Main {
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);

		ClienteDAO clienteDAO = contexto.getBean("clienteDAO", ClienteDAO.class);
		
		boolean aux = true;
		
		try {
			
			clienteDAO.getClientes(aux);
			
		} catch(Exception e) {
			
			System.err.print("Excepción lanzada desde el main: ");
			System.err.println(e.getMessage());
		}
		
		System.out.println("El programa ha finalizado");
		
		contexto.close();
	}
}
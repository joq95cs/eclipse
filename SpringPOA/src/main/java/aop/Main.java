package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aop.dao.ClienteDAO;
import aop.dao.ClienteEspecialDAO;

public class Main {
	
	public static void main(String[] args) {
		
		//Leer la configuracion de spring
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//Obtener el bean del contenedor de spring
		ClienteDAO clienteDAO = contexto.getBean("clienteDAO", ClienteDAO.class);
		ClienteEspecialDAO clienteEspecialDAO = contexto.getBean("clienteEspecialDAO", ClienteEspecialDAO.class);
		
		//Llamar al método
		Cliente cliente = new Cliente();
		clienteDAO.insertarCliente(cliente, "Normal");
		clienteEspecialDAO.insertarClienteEspecial();
		
		//Cerrar el contexto
		
		clienteDAO.setValoracionCliente("Positiva");
		clienteDAO.setCodigoCliente("14040099");
		
		String valoracionCliente = clienteDAO.getValoracionCliente();
		String codigoCliente = clienteDAO.getCodigoCliente();
		
		contexto.close();
	}
}
package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aop.dao.ClienteDAO;
import aop.dao.ClienteEspecialDAO;

public class Main {
	
	public static void main(String[] args) {

		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(Configuracion.class);

		ClienteDAO clienteDAO = contexto.getBean("clienteDAO", ClienteDAO.class);
		ClienteEspecialDAO clienteEspecialDAO = contexto.getBean("clienteEspecialDAO", ClienteEspecialDAO.class);
		
		Cliente cliente = new Cliente();
		cliente.setNombre("Joqsan Castellanos");
		cliente.setTipo("Normal");
		clienteDAO.insertarCliente(cliente, cliente.getTipo());
		clienteEspecialDAO.insertarClienteEspecial();
		
		contexto.close();
	}
}
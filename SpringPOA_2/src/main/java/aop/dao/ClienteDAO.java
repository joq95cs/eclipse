package aop.dao;

import org.springframework.stereotype.Component;
import aop.Cliente;

@Component
public class ClienteDAO {

	public void insertarCliente(Cliente cliente, String tipo) {
		
		System.out.println("Cliente insertado correctamente");
	}
}
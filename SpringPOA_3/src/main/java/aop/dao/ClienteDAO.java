package aop.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import aop.Cliente;

@Component
public class ClienteDAO {

	public void insertarCliente(Cliente cliente, String tipo) {
		
		System.out.println("Cliente insertado correctamente");
	}
	
	public ArrayList<Cliente> getClientes(boolean aux) {
		
		if(aux) {
			
			throw new RuntimeException("ERROR");
		}
		
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		//Simular clientes devueltos
		
		Cliente cl1 = new Cliente("Chayo", "Normal");
		Cliente cl2 = new Cliente("Especia", "Especial");
		Cliente cl3 = new Cliente("Fresa", "Normal");
		Cliente cl4 = new Cliente("Pepina", "Especial");
		Cliente cl5 = new Cliente("Calabazo", "Especial");
		
		//Agregar clientes a lista
		
		clientes.add(cl1);
		clientes.add(cl2);
		clientes.add(cl3);
		clientes.add(cl4);
		clientes.add(cl5);
		
		System.out.println("getClientes() ha finalizado");
		
		return clientes;
	}
}
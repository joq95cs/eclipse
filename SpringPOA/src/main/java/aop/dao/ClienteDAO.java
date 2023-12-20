package aop.dao;

import org.springframework.stereotype.Component;
import aop.Cliente;

@Component
public class ClienteDAO {

	public void insertarCliente(Cliente cliente, String tipo) {
		
		System.out.println("Cliente insertado correctamente");
	}
	
	public void setValoracionCliente(String valoracionCliente) {
		
		System.out.println("Fijando valoración");
		
		this.valoracionCliente = valoracionCliente;
	}
	
	public String getValoracionCliente() {
		
		System.out.println("Obteniendo valoración");
		
		return valoracionCliente;
	}
	
	public void setCodigoCliente(String codigoCliente) {
		
		System.out.println("Fijando código");
		
		this.codigoCliente = codigoCliente;
	}
	
	public String getCodigoCliente() {
		
		System.out.println("Obteniendo código");
		
		return codigoCliente;
	}

	private String valoracionCliente;
	private String codigoCliente;
}
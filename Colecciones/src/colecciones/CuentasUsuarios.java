package colecciones;

import java.util.*;

public class CuentasUsuarios {

	public static void main(String[] args) {
		
		Cliente cl1 = new Cliente("Antonio Banderas", "00001", 200000);
		
		Cliente cl2 = new Cliente("Rafael Nadal", "00002", 2500000);
		
		Cliente cl3 = new Cliente("Penélope Cruz", "00003", 300000);
		
		Cliente cl4 = new Cliente("Julio Iglesias", "00004", 500000);
		
		Cliente cl5 = new Cliente("Antonio Banderas", "00009", 200000);
		
		Set<Cliente> clientesBanco = new HashSet<Cliente>();
		
		clientesBanco.add(cl1);
		
		clientesBanco.add(cl2);
		
		clientesBanco.add(cl3);
		
		clientesBanco.add(cl4);
		
		clientesBanco.add(cl5);
		
		/*for(Cliente cliente: clientesBanco) {
			
			if(cliente.getNombre().equals("Julio Iglesias")) {
				
				clientesBanco.remove(cliente);
				
			}
			
		}*///No se puede eliminar un elemento de una colección mientras se recorre. Problema de concurrencia.
		
		
		Iterator<Cliente> it = clientesBanco.iterator();
		
		while(it.hasNext()) {
			
			String nombre_cliente = it.next().getNombre();
			
			if(nombre_cliente.equals("Julio Iglesias")) {
				
				it.remove(); //Elimina el objeto actual.
				
			}
			
		}
		
		for(Cliente cliente: clientesBanco) {
			
			System.out.println(cliente.getNombre() + " " +
			cliente.getNo_cuenta() + " " + cliente.getSaldo());
			
		}
		
		/*Iterator<Cliente> it = clientesBanco.iterator();
		
		while(it.hasNext()) {
			
			String nombre_cliente = it.next().getNombre();
			
			System.out.println(nombre_cliente);
			
		}*/

	}

}

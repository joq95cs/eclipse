package aop.aspectos;

import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aop.Cliente;

@Aspect
@Component
@Order(2)
public class Login {
	
	@AfterReturning(pointcut="execution(* aop.dao.ClienteDAO.getClientes(..))", returning="clientes")
	public void tareaFinal(ArrayList<Cliente> clientes) {
		
		for(Cliente cliente: clientes) {
			
			if(cliente.getTipo().equals("Especial")) {
				
				procesar(cliente);
				
				System.out.println("Cliente: " + cliente.getNombre());
			}
		}
	}
	
	private void procesar(Cliente cliente) {
			
		String nuevoNombre = cliente.getNombre().toUpperCase() + " (Especial)";
		cliente.setNombre(nuevoNombre);
	}

	@Pointcut("execution(* aop.dao.*.*(..))")
	public void comprobaciones() {}

	@Before("comprobaciones()")
	public void comprobar(JoinPoint jp) {
		
		System.out.println("El usuario ha hecho login");
		System.out.println("El perfil de usuario es correcto");
		
		Object [] args = jp.getArgs();
		
		for(Object temp: args) {
			
			if(temp instanceof Cliente) {
				
				Cliente cliente = (Cliente) temp;
				System.out.println("Nombre: " + cliente.getNombre());
				System.out.println("Tipo: " + cliente.getTipo());
			}
		}
	}
	
	@AfterThrowing(pointcut="execution(* aop.dao.ClienteDAO.getClientes(..))", throwing="excepciones")
	public void excepciones(Throwable excepciones) {
		
		System.out.println("Estas son las tareas que se ejecutan después de la excepción");
	}

	@After("execution(* aop.dao.ClienteDAO.getClientes(..))")
	public void tareasAutomaticas(JoinPoint jp) {
		
		System.out.println("Tareas que se ejecutan siempre");
		
		
	}
}
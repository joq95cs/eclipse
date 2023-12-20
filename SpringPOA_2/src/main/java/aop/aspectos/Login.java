package aop.aspectos;

import org.aspectj.lang.JoinPoint;
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
}
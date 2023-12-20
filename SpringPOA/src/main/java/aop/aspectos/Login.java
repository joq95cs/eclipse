package aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Login {
	
	//@Pointcut("execution(public * insertarCliente*(..))")
	@Pointcut("execution(* aop.dao.*.*(..))")
	private void comprobaciones() {}
	
	@Pointcut("execution(* aop.dao.*.get*(..))")
	private void getters() {}
	
	@Pointcut("execution(* aop.dao.*.set*(..))")
	private void setters() {}
	
	//@Pointcut("comprobaciones() && !(getters() || setters())")
	@Pointcut("comprobaciones() && !setters()")
	private void comprobaciones2() {}

	//@Before("comprobaciones()") //Poincut expression
	@Before("comprobaciones2()")
	public void comprobar() {
		
		System.out.println("El usuario ha hecho login"); //Tarea 1
		System.out.println("El perfil de usuario es correcto"); //Tarea 2
	}
	
	//@Before("comprobaciones()")
	public void requisitosCliente() {
		
		System.out.println("El cliente puede ser insertado");
	}
	
	//@Before("comprobaciones()")
	public void requisitosTabla() {
		
		System.out.println("Hay menos de 3000 registros");
	}
}
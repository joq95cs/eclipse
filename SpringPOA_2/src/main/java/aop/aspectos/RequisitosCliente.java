package aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class RequisitosCliente {
	
	@Before("aop.aspectos.Login.comprobaciones()")
	public void requisitosCliente() {
		
		System.out.println("El cliente puede ser insertado");
	}
}
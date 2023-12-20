package aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class RequisitosTabla {
	
	@Before("aop.aspectos.Login.comprobaciones()")
	public void requisitosTabla() {
		
		System.out.println("Hay menos de 3000 registros");
	}
}
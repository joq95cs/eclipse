package validaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CPValidacion.class) //Clase que contiene la l�gica de la validaci�n
@Target({ElementType.METHOD, ElementType.FIELD}) //Destino de la validaci�n a m�todos o campos
@Retention(RetentionPolicy.RUNTIME) //Verifica la anotaci�n en tiempo de ejecuci�n
public @interface CodigoPostal {
	
	//Definir el c�digo postal por defecto
	
	public String value() default "60";
	
	//Definir mensaje de error
	
	public String message() default "El CP debe comenzar con 60";
	
	//Definir los grupos
	
	Class<?>[] groups() default {};
	
	//Definir los payloads
	
	Class<? extends Payload>[] payload() default {};
}
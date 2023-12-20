package validaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CPValidacion.class) //Clase que contiene la lógica de la validación
@Target({ElementType.METHOD, ElementType.FIELD}) //Destino de la validación a métodos o campos
@Retention(RetentionPolicy.RUNTIME) //Verifica la anotación en tiempo de ejecución
public @interface CodigoPostal {
	
	//Definir el código postal por defecto
	
	public String value() default "60";
	
	//Definir mensaje de error
	
	public String message() default "El CP debe comenzar con 60";
	
	//Definir los grupos
	
	Class<?>[] groups() default {};
	
	//Definir los payloads
	
	Class<? extends Payload>[] payload() default {};
}
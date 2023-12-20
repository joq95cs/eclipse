package validaciones;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPValidacion implements ConstraintValidator<CodigoPostal, String> {

	@Override
    public void initialize(CodigoPostal codigoPostal) {
		
		prefijo = codigoPostal.value();
    }
	
	@Override
	public boolean isValid(String codigoRecibido, ConstraintValidatorContext context) {
		
		boolean valido;
		
		if(codigoRecibido != null) {
			
			valido = codigoRecibido.startsWith(prefijo);
			
		} else {
			
			return valido = true;
		}
		
		return valido;
	}
	
	private String prefijo;
}

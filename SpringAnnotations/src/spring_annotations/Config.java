package spring_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("spring_annotations")
@PropertySource("classpath:DatosEmpresa.propiedades")
public class Config {
	
	//Definir el bean para informe financiero del depto. de compras
	@Bean
	public CreacionInformeFinanciero getInformeFinancieroCompras() {
		
		return new InformeFinancieroCompras();
	}
	
	//Definir el bean para DirectorFinanciero e inyectar dependencia
	
	@Bean
	public Empleados getDirectorFinanciero() { //el id es getDirectorFinanciero
		
		return new DirectorFinanciero(getInformeFinancieroCompras());
	}
}
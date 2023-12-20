package spring_mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador {
	
	@RequestMapping //Se ejecuta como el index
	public String muestraPagina() {
		
		return "Inicio";
	}
}

package spring_mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/principal")
public class SaludoControlador {
	
	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() { //Proporciona el formulario
		
		return "SaludoFormulario";
	}
	
	@RequestMapping("/procesarFormulario1")
	public String procesarFormulario1() {
		
		return "Saludo";
	}
	
	@RequestMapping("/procesarFormulario2")
	//public String procesarFormulario2(HttpServletRequest request, Model modelo) {
	public String procesarFormulario2(@RequestParam("nombre") String nombre, Model modelo) {
		
		//String nombre = request.getParameter("nombre"); //El name del input
		nombre += " es el mejor alumno...";
		
		String mensaje = "¿Quién es el mejor alumno? " + nombre;
		
		modelo.addAttribute("mensaje", mensaje); //Se jala con el tag
		
		return "Saludo";
	}
}
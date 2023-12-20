package spring_mvc1;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alumno")
public class AlumnoControlador {
	
	@InitBinder
	public void binder(WebDataBinder binder) {
		
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, trimmer);
	}
	
	@RequestMapping("/irFormularioRegistroAlumno")
	public String irFormularioRegistroAlumno(Model modelo) {
		
		Alumno alumno = new Alumno();
		modelo.addAttribute("alumno", alumno);
		
		return "FormularioRegistroAlumno";
	}
	
	@RequestMapping("/procesarFormulario")
	public String procesarFormulario(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult validacion) {
		
		if(validacion.hasErrors()) {
			
			return "FormularioRegistroAlumno";
			
		}
			
		return "ConfirmacionRegistroAlumno";
	}
}
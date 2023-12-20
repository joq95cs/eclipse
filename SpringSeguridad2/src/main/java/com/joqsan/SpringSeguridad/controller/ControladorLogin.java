package com.joqsan.SpringSeguridad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorLogin {
	
	@GetMapping("/formLogin")
	public String login() {
		
		return "formulario";
	}
}

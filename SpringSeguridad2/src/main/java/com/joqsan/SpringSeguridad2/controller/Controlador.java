package com.joqsan.SpringSeguridad2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

	@GetMapping("/")
	public String getInicio() {
		
		return "inicio";
	}
}

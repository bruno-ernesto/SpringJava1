package com.example.parte1.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping(value = "/login")
	public String login(@RequestParam(value = "error", required=false) String error,
			@RequestParam(value = "logout", required=false) String logout,
			Model model, 
			Principal principal, RedirectAttributes attribute) {
		if(error!=null) {
			model.addAttribute("error", "ERROR DE ACCESO: usuario o contraseña incorrectos");
		}
		if(logout!=null) {
			model.addAttribute("success", "ATENCION: usted ha cerrado su sesion correctamente");
		}
		if(principal!=null) {
			attribute.addFlashAttribute("warning", "ATENCION: usted ya ha iniciado sesion previamente");
			return "redirect:/index";
		}
		return "login";
	}
}

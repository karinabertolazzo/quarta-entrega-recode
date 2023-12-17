package com.bertolazzoilhas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/home")
	public String Index () { 
		return "index";
	}
	
	@GetMapping("/destinos")
	public String Destinos () { 
		return "index";
	}
	
	@GetMapping("/promocoes")
	public String Promocoes () { 
		return "index";
	}
	
	@GetMapping("/contato")
	public String Contato () { 
		return "index";
	}
	
	@GetMapping("/entrarCadastrar")
	public String EntrarCadastrar () { 
		return "index";
	}
}

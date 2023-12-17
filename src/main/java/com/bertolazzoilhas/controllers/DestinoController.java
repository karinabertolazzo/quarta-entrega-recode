package com.bertolazzoilhas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bertolazzoilhas.model.Destino;
import com.bertolazzoilhas.services.DestinoService;

@Controller
@RequestMapping("/Destinos")
public class DestinoController {

	@Autowired
	private DestinoService destinoService;

	// Listar
	@GetMapping
	public String listDestinos(Model model) {
		List<Destino> destinos = destinoService.getAllDestino();
		model.addAttribute("Destino", destinos);
		return "ListarDestinos";
	}

	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Destino destino = new Destino();
		model.addAttribute("Destino", destino);
		return "DestinosCadastro";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveDestino(@ModelAttribute("Destinos") Destino destino) {
		destinoService.saveDestino(destino);
		return "redirect:/Destinos";
	}

	// Formulário de edição
	@GetMapping("/editarDestino/{idDestino}")
	public String showFormForUpdate(@PathVariable("idDestino") Long idDestino, Model model) {
		Destino destino = destinoService.getDestinoById(idDestino);
		model.addAttribute("Destino", destino);
		return "EditarDestinos";
	}

	// Persistencia da edição
	@PostMapping("/editar/{idDestino}")
	public String updateDestino(@PathVariable Long idDestino, @ModelAttribute("Destino") 
	Destino destino) {
		destinoService.updateDestino(idDestino, destino);
		return "redirect:/Destinos";
	}
	
	// Excluir Destino
	@GetMapping("/deletar/{idDestino}")
	public String deleteDestino(@PathVariable ("idDestino") Long idDestino) { 
		destinoService.deleteDestino(idDestino);
		return "redirect:/Destinos";
	}

}

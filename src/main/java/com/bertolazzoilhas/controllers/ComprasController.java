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

import com.bertolazzoilhas.model.Cliente;
import com.bertolazzoilhas.model.Compras;
import com.bertolazzoilhas.model.Destino;
import com.bertolazzoilhas.services.ClienteService;
import com.bertolazzoilhas.services.ComprasService;
import com.bertolazzoilhas.services.DestinoService;

@Controller
@RequestMapping("/Compras")
public class ComprasController {

	@Autowired
	private ComprasService comprasService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private DestinoService destinoService;

	// Listar
	@GetMapping
	public String listComprass(Model model) {
		List<Compras> compras = comprasService.getAllCompras();
		model.addAttribute("compras", compras);
		return "ListarCompras";
	}

	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
						
		List<Cliente> listaC = clienteService.getAllCliente();
		model.addAttribute("cliente", listaC);
		List<Destino> listaD = destinoService.getAllDestino();
		model.addAttribute("destino", listaD);
		
		Compras compras = new Compras();
		model.addAttribute("Compras", compras);
		
		return "ComprasCadastro";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveCompras(@ModelAttribute("Compras") Compras compras) {
		comprasService.saveCompras(compras);
		return "redirect:/Compras";
	}

	// Formulário de edição
	@GetMapping("/editar/{idCompras}")
	public String showFormForUpdate(@PathVariable Long idCompras, Model model) {
		Compras compras = comprasService.getComprasById(idCompras);
		model.addAttribute("Compras", compras);
		return "EditarCompras";
	}

	// Persistencia da edição
	@PostMapping("/editar/{idCompras}")
	public String updateCompras(@PathVariable ("idCompras")Long idCompras, @ModelAttribute("Compras") 
	Compras compras) {
		comprasService.updateCompras(idCompras, compras);
		return "redirect:/Compras";
	}
	
	// Excluir Compras
	@GetMapping("/deletar/{idCompras}")
	public String deleteCompras(@PathVariable ("idCompras") Long idCompras) { 
		comprasService.deleteCompras(idCompras);
		return "redirect:/Compras";
	}

}

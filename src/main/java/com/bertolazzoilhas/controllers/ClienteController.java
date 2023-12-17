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
import com.bertolazzoilhas.services.ClienteService;

@Controller
@RequestMapping("/Clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// Listar
	@GetMapping
	public String listClientes(Model model) {
		List<Cliente> Clientes = clienteService.getAllCliente();
		model.addAttribute("clientes", Clientes);
		return "ListarClientes";
	}

	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("Cliente", cliente);
		return "ClienteCadastro";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveCliente(@ModelAttribute("Cliente") Cliente cliente) {
		clienteService.saveCliente(cliente);
		return "redirect:/Clientes";
	}

	// Formulário de edição
	@GetMapping("/editar/{idCliente}")
	public String showFormForUpdate(@PathVariable("idCliente") Long idCliente, Model model) {
		Cliente cliente = clienteService.getClienteById(idCliente);
		model.addAttribute("Cliente", cliente);
		return "EditarCliente";
	}

	// Persistencia da edição
	@PostMapping("/editar/{idCliente}")
	public String updateCliente(@PathVariable Long idCliente, @ModelAttribute("Cliente") 
	Cliente cliente) {
		clienteService.updateCliente(idCliente, cliente);
		return "redirect:/Clientes";
	}
	
	// Excluir Cliente
	@GetMapping("/deletar/{idCliente}")
	public String deleteCliente(@PathVariable ("idCliente") Long idCliente) { 
		clienteService.deleteCliente(idCliente);
		return "redirect:/Clientes";
	}

}

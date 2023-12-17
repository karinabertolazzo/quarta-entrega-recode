package com.bertolazzoilhas.services;

import java.util.List;

import com.bertolazzoilhas.model.Cliente;

public interface ClienteService {

	List<Cliente> getAllCliente();
	
	Cliente getClienteById(Long idCliente);
	
	Cliente saveCliente(Cliente cliente);
	
	Cliente updateCliente(Long idCliente, Cliente clienteAtualizado);
	
	void deleteCliente(Long idCliente);
}

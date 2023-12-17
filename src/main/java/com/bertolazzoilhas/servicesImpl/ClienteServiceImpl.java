package com.bertolazzoilhas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bertolazzoilhas.model.Cliente;
import com.bertolazzoilhas.repositories.ClienteRepository;
import com.bertolazzoilhas.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllCliente() {
		return clienteRepository.findAll();
		}

	@Override
	@Transactional(readOnly = true)
	public Cliente getClienteById(Long idCliente) {
		return clienteRepository.findById(idCliente).orElse(null);
	}

	@Override
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(Long idCliente, Cliente clienteAtualizado) {
		Cliente clienteExistente = clienteRepository.findById(idCliente).orElse(null);
		if (clienteExistente != null) { 
			clienteExistente.setNomeCliente(clienteAtualizado.getNomeCliente());
			clienteExistente.setCpfCliente(clienteAtualizado.getCpfCliente());
			clienteExistente.setEnderecoCliente(clienteAtualizado.getEnderecoCliente());
			clienteExistente.setTelefoneCliente(clienteAtualizado.getTelefoneCliente());
			clienteExistente.setEmailCliente(clienteAtualizado.getEmailCliente());
			clienteExistente.setSenhaCliente(clienteAtualizado.getSenhaCliente());
			
			return clienteRepository.save(clienteExistente);
		} else { 
			throw new RuntimeException("Cliente com o IDCliente" + idCliente + "não encontrada.");
		}
	}

	@Override
	public void deleteCliente(Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}

}

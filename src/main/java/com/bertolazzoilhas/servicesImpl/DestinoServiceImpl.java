package com.bertolazzoilhas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bertolazzoilhas.model.Destino;
import com.bertolazzoilhas.repositories.DestinoRepository;
import com.bertolazzoilhas.services.DestinoService;

@Service
public class DestinoServiceImpl implements DestinoService {
	
	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	public List<Destino> getAllDestino() {
		return destinoRepository.findAll();
		}

	@Override
	@Transactional(readOnly = true)
	public Destino getDestinoById(Long idDestino) {
		return destinoRepository.findById(idDestino).orElse(null);
	}

	@Override
	@Transactional
	public Destino saveDestino(Destino Destino) {
		return destinoRepository.save(Destino);
	}

	@Override
	public Destino updateDestino(Long idDestino, Destino DestinoAtualizado) {
		Destino DestinoExistente = destinoRepository.findById(idDestino).orElse(null);
		if (DestinoExistente != null) { 
			DestinoExistente.setNomeDestino(DestinoAtualizado.getNomeDestino());
			DestinoExistente.setDescricao(DestinoAtualizado.getDescricao());
			DestinoExistente.setValorPromocionalDestino(DestinoAtualizado.getValorPromocionalDestino());
			DestinoExistente.setPromocoesDestino(DestinoAtualizado.getPromocoesDestino());
			DestinoExistente.setValorDestino(DestinoAtualizado.getValorDestino());
			DestinoExistente.setFoto(DestinoAtualizado.getFoto());
			
			return destinoRepository.save(DestinoExistente);
		} else { 
			throw new RuntimeException("Destino com o IDDestino" + idDestino + "não encontrado.");
		}
	}

	@Override
	public void deleteDestino(Long idDestino) {
		destinoRepository.deleteById(idDestino);
	}

}

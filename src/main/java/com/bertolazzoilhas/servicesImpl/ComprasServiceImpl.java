package com.bertolazzoilhas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bertolazzoilhas.model.Compras;
import com.bertolazzoilhas.repositories.ComprasRepository;
import com.bertolazzoilhas.services.ComprasService;

@Service
public class ComprasServiceImpl implements ComprasService {
	
	@Autowired
	private ComprasRepository comprasRepository;

	@Override
	public List<Compras> getAllCompras() {
		return comprasRepository.findAll();
		}

	@Override
	@Transactional(readOnly = true)
	public Compras getComprasById(Long idCompras) {
		return comprasRepository.findById(idCompras).orElse(null);
	}

	@Override
	@Transactional
	public Compras saveCompras(Compras Compras) {
		return comprasRepository.save(Compras);
	}

	@Override
	public Compras updateCompras(Long idCompras, Compras ComprasAtualizadas) {
		Compras ComprasExistente = comprasRepository.findById(idCompras).orElse(null);
		if (ComprasExistente != null) { 
			ComprasExistente.setTipoCompras(ComprasAtualizadas.getTipoCompras());
			ComprasExistente.setQuantidadeCompras(ComprasAtualizadas.getQuantidadeCompras());
			ComprasExistente.setDataCompras(ComprasAtualizadas.getDataCompras());
			ComprasExistente.setValorTotalCompras(ComprasAtualizadas.getValorTotalCompras());
			ComprasExistente.setStatusCompras(ComprasAtualizadas.getStatusCompras());

			return comprasRepository.save(ComprasExistente);
		} else { 
			throw new RuntimeException("Compras com o IDCompras" + idCompras + "não encontradas.");
		}
	}

	@Override
	public void deleteCompras(Long idCompras) {
		comprasRepository.deleteById(idCompras);
	}

}

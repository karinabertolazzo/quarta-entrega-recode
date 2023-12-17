package com.bertolazzoilhas.services;

import java.util.List;

import com.bertolazzoilhas.model.Compras;

public interface ComprasService {

	List<Compras> getAllCompras();
	
	Compras getComprasById(Long idCompras);
	
	Compras saveCompras(Compras compras);
	
	Compras updateCompras(Long idCompras, Compras ComprasAtualizado);
	
	void deleteCompras(Long idCompras);
}

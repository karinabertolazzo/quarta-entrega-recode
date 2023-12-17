package com.bertolazzoilhas.services;

import java.util.List;

import com.bertolazzoilhas.model.Destino;

public interface DestinoService {

	List<Destino> getAllDestino();
	
	Destino getDestinoById(Long idDestino);
	
	Destino saveDestino(Destino destino);
	
	Destino updateDestino(Long idDestino, Destino DestinoAtualizado);
	
	void deleteDestino(Long idDestino);
}

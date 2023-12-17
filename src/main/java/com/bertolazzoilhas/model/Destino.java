package com.bertolazzoilhas.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestino;
	@Column(nullable = false , length = 100)
	private String nomeDestino;
	@Column(nullable = false , length = 100)
	private String descricao;
	@Column(nullable = false , length = 100)
	private String foto;
	@Column
	private String valorDestino;
	@Column(nullable = false)
	private Integer promocoesDestino;
	@Column
	private Double valorPromocionalDestino;
	
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)         
    @JoinColumn(name = "idDestino")
    private List<Compras> compras;
	
	
	public Destino() {
		super();
		
	}


	public Destino(Long idDestino, String nomeDestino, String descricao, String foto, String valorDestino,
			Integer promocoesDestino, Double valorPromocionalDestino) {
		super();
		this.idDestino = idDestino;
		this.nomeDestino = nomeDestino;
		this.descricao = descricao;
		this.foto = foto;
		this.valorDestino = valorDestino;
		this.promocoesDestino = promocoesDestino;
		this.valorPromocionalDestino = valorPromocionalDestino;
	}


	public Long getIdDestino() {
		return idDestino;
	}


	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
	}


	public String getNomeDestino() {
		return nomeDestino;
	}


	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getValorDestino() {
		return valorDestino;
	}


	public void setValorDestino(String valorDestino) {
		this.valorDestino = valorDestino;
	}


	public Integer getPromocoesDestino() {
		return promocoesDestino;
	}


	public void setPromocoesDestino(Integer promocoesDestino) {
		this.promocoesDestino = promocoesDestino;
	}


	public Double getValorPromocionalDestino() {
		return valorPromocionalDestino;
	}


	public void setValorPromocionalDestino(Double valorPromocionalDestino) {
		this.valorPromocionalDestino = valorPromocionalDestino;
	}


	public List<Compras> getCompras() {
		return compras;
	}


	public void setCompras(List<Compras> compras) {
		this.compras = compras;
	}

		



	
	
	
	
}

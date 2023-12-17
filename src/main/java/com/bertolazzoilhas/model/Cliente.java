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
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	@Column
	private String nomeCliente;
	@Column
	private String cpfCliente;
	@Column
	private String enderecoCliente;
	@Column
	private String telefoneCliente;
	@Column
	private String emailCliente;
	@Column
	private String senhaCliente;
	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente")
    private List<Compras> compras;
	
		public Cliente() {
		super();
	
	}
	
	
		
	public Cliente(Long idCliente, String nomeCliente, String cpfCliente, String enderecoCliente,
				String telefoneCliente, String emailCliente, String senhaCliente) {
			super();
			this.idCliente = idCliente;
			this.nomeCliente = nomeCliente;
			this.cpfCliente = cpfCliente;
			this.enderecoCliente = enderecoCliente;
			this.telefoneCliente = telefoneCliente;
			this.emailCliente = emailCliente;
			this.senhaCliente = senhaCliente;
		}



	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getEnderecoCliente() {
		return enderecoCliente;
	}
	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}
	public String getTelefoneCliente() {
		return telefoneCliente;
	}
	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getSenhaCliente() {
		return senhaCliente;
	}
	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	public List<Compras> getCompras() {
		return compras;
	}

	public void setCompras(List<Compras> compras) {
		this.compras = compras;
	}
	
	
	
	
	
	
}

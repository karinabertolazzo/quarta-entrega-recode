package com.bertolazzoilhas.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Compras")
public class Compras {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idCompras;
		@Column(nullable = false , length = 50)
		private String tipoCompras;
		@Column(nullable =  false , length = 11)
		private Integer quantidadeCompras;
		@Column
		private LocalDate dataCompras;	
		@Column(nullable =  false , length = 9)
		private String valorTotalCompras;
		@Column(nullable = false , length = 20)
		private String statusCompras;
		
		@ManyToOne
        @JoinColumn(name = "idCliente")
        private Cliente cliente;
		
		@ManyToOne
        @JoinColumn(name = "idDestino")
        private Destino destino;
		
		public Compras() {
			super();
			
		}

		public Compras(Long idCompras, String tipoCompras, Integer quantidadeCompras, LocalDate dataCompras,
				String valorTotalCompras, String statusCompras) {
			super();
			this.idCompras = idCompras;
			this.tipoCompras = tipoCompras;
			this.quantidadeCompras = quantidadeCompras;
			this.dataCompras = dataCompras;
			this.valorTotalCompras = valorTotalCompras;
			this.statusCompras = statusCompras;
		}

		public Long getIdCompras() {
			return idCompras;
		}

		public void setIdCompras(Long idCompras) {
			this.idCompras = idCompras;
		}

		public String getTipoCompras() {
			return tipoCompras;
		}

		public void setTipoCompras(String tipoCompras) {
			this.tipoCompras = tipoCompras;
		}

		public Integer getQuantidadeCompras() {
			return quantidadeCompras;
		}

		public void setQuantidadeCompras(Integer quantidadeCompras) {
			this.quantidadeCompras = quantidadeCompras;
		}

		public LocalDate getDataCompras() {
			return dataCompras;
		}

		public void setDataCompras(LocalDate dataCompras) {
			this.dataCompras = dataCompras;
		}

		public String getValorTotalCompras() {
			return valorTotalCompras;
		}

		public void setValorTotalCompras(String valorTotalCompras) {
			this.valorTotalCompras = valorTotalCompras;
		}

		public String getStatusCompras() {
			return statusCompras;
		}

		public void setStatusCompras(String statusCompras) {
			this.statusCompras = statusCompras;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Destino getDestino() {
			return destino;
		}

		public void setDestino(Destino destino) {
			this.destino = destino;
		}
		
		
	
}


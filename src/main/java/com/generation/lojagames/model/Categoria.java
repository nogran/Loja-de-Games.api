package com.generation.lojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categorias")

public class Categoria {
	
	@Id // PK // @GeneratedValue = PK sera gerada automaticamente.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY = auto-increment.
	private Long id;
	
	@NotNull(message = "Tipo é obrigatório!")
	@Size(min = 5)
	private String tipo;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) // Cascade = deletar 1 categoria, os produtos tambem sao deletados.
	@JsonIgnoreProperties("categoria") // Quebrar loop recursividade exibicao JSON.
	private List<Produto> produto; // Array de produtos.

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}

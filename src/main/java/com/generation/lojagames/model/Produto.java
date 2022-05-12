package com.generation.lojagames.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity                		// Entidade para gerar tabela no BD.
@Table(name = "tb_produtos")
public class Produto {
	
	@Id	// PK	// @GeneratedValue = PK sera gerada automaticamente.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY = auto-increment.
	private Long Id;

	@NotBlank(message = "Nome é obrigatório!")                                       										
	private String nome;
	
	@Size(max=500)
	private String descricao;
	
	@NotNull(message = "Console é obrigatório!")
	private String console;
	
	private int quantidade;
	
	@Column(name = "data_lancamento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataLancamento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING) 
	@NotNull(message = "Preço é obrigatório!")
	@Positive(message = "O preço deve ser maior do que zero!")
	private BigDecimal preco;
	
	private String foto;
	
	@ManyToOne // Relacionamento "produto" um para muitos com a Classe Categoria.
	@JsonIgnoreProperties("produto") // Quebra recursividade infinita durante exibicao JSON.
	private Usuario usuario;

	@ManyToOne // Relacionamento "produto" um para muitos com a Classe Categoria.
	@JsonIgnoreProperties("produto") // Quebra recursividade infinita durante exibicao JSON.
	private Categoria categoria; // Objeto do tipo categoria atuara como chave estrangeira da Classe Produto. (Criar getters e setters).

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}

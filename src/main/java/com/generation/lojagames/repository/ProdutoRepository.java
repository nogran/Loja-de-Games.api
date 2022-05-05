package com.generation.lojagames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{ // Ask
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	 
	public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);
	 
	public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);

}

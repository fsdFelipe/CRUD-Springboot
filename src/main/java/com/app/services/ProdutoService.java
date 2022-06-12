package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.domain.Produto;
import com.app.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	// Serviço que acessa a tabela Produto no banco de dados e procura uma Produto pelo Id fornecido
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	// Serviço que acessa a tabela Produto no banco de dados e adiciona uma  nova Produto
	public Produto insert(Produto obj) {
		return repo.save(obj);
	}
	
	// Serviço que acessa a tabela Produto no banco de dados e procura uma Produto pelo Id fornecido
	// faz a alteração desejada e salva no Banco de dados
	public Produto update(Produto obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	// Serviço que acessa a tabela Produto no banco de dados e exclui uma Produto pelo Id fornecido
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	// Serviço que acessa a tabela Produto no banco de dados e busca todoas as Produtos cadastradas
	public List<Produto> findAll(){
		return repo.findAll();
	}

}

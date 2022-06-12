package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.domain.Categoria;
import com.app.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	// Serviço que acessa a tabela Categoria no banco de dados e procura uma categoria pelo Id fornecido
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	// Serviço que acessa a tabela Categoria no banco de dados e adiciona uma  nova categoria
	public Categoria insert(Categoria obj) {
		return repo.save(obj);
	}
	
	// Serviço que acessa a tabela Categoria no banco de dados e procura uma categoria pelo Id fornecido
	// faz a alteração desejada e salva no Banco de dados
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	// Serviço que acessa a tabela Categoria no banco de dados e exclui uma categoria pelo Id fornecido
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	// Serviço que acessa a tabela Categoria no banco de dados e busca todoas as Categorias cadastradas
	public List<Categoria> findAll(){
		return repo.findAll();
	}

}

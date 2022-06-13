package com.app.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.app.domain.Categoria;
import com.app.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private List<Categoria> categoriaId;

	public ProdutoDTO() {

	}

public ProdutoDTO(Produto obj) {
		id= obj.getId();
		nome= obj.getNome();
		categoriaId = obj.getCategorias();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Categoria> getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(List<Categoria> categoriaId) {
		this.categoriaId = categoriaId;
	}

}

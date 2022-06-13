package com.app.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.app.domain.Categoria;
import com.app.domain.Produto;
import com.app.repositories.CategoriaRepository;
import com.app.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		//instanciando categorias
				Categoria cat1 = new Categoria();
			    cat1.setNome("Informatica");
				Categoria cat2 = new Categoria();
				cat2.setNome("Escritório");
				Categoria cat3 = new Categoria();
				cat3.setNome("Cama mesa e Banho");
				Categoria cat4 = new Categoria();
				cat4.setNome("Acessórios");
				Categoria cat5 = new Categoria();
				cat5.setNome("Computadores");
				Categoria cat6 = new Categoria();
				cat6.setNome("Telefonia");
				Categoria cat7 = new Categoria();
				cat7.setNome("Ferramentas");

				//instanciando produtos
				Produto p1 = new Produto(); 
				p1.setNome("Computador");
				p1.setPreco(2000.00);
				Produto p2 = new Produto();
				p2.setNome("Impressora");
				p2.setPreco(800.00);
				Produto p3 = new Produto();
				p3.setNome("Mouse");
				p3.setPreco(80.00);
				Produto p4 = new Produto(); 
				p4.setNome("Roteador");
				p4.setPreco(100.00);
				Produto p5 = new Produto();
				p5.setNome("Headset");
				p5.setPreco(90.00);
				Produto p6 = new Produto();
				p6.setNome("Grampeador");
				p6.setPreco(10.00);
				Produto p7 = new Produto();
				p7.setNome("Celular");
				p7.setPreco(1000.00);
				Produto p8 = new Produto();
				p8.setNome("Multimetro");
				p8.setPreco(100.00);


				//adicionando produtos as respectivas categorias
				cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3,p4,p5));
				cat2.getProdutos().addAll(Arrays.asList(p2,p6));
				cat4.getProdutos().addAll(Arrays.asList(p5,p6));
				cat5.getProdutos().addAll(Arrays.asList(p1));
				cat6.getProdutos().addAll(Arrays.asList(p7));
				cat7.getProdutos().addAll(Arrays.asList(p8));

				// adicionando categorias aos respectivos produtos
				p1.getCategorias().addAll(Arrays.asList(cat1, cat5));
				p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
				p3.getCategorias().addAll(Arrays.asList(cat1));
				p4.getCategorias().addAll(Arrays.asList(cat1));
				p5.getCategorias().addAll(Arrays.asList(cat1,cat4));
				p6.getCategorias().addAll(Arrays.asList(cat2, cat4));
				p7.getCategorias().addAll(Arrays.asList(cat6));
				p8.getCategorias().addAll(Arrays.asList(cat7));
				
				//salvando as categorias no Banco de dados
				categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
				//salvando os produtos no banco de dados
				produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));

	}
}

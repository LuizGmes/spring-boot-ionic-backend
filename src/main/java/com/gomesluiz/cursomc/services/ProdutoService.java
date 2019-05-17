package com.gomesluiz.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gomesluiz.cursomc.domain.Categoria;
import com.gomesluiz.cursomc.domain.Produto;
import com.gomesluiz.cursomc.repositories.CategoriaRepository;
import com.gomesluiz.cursomc.repositories.ProdutoRepository;
import com.gomesluiz.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer Id) {
		Optional<Produto> obj = repo.findById(Id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + Id + ", Tipo: " + Produto.class.getName()));
		
	}
	
	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
	
}

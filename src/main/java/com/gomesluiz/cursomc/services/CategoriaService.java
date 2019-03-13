package com.gomesluiz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomesluiz.cursomc.domain.Categoria;
import com.gomesluiz.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer Id) {
		Optional<Categoria> obj = repo.findById(Id);
		return obj.orElse(null);
	}
}

package com.gomesluiz.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomesluiz.cursomc.domain.Cliente;
import com.gomesluiz.cursomc.repositories.ClienteRepository;
import com.gomesluiz.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer Id) {
		Optional<Cliente> obj = repo.findById(Id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + Id + ", Tipo: " + Cliente.class.getName()));
		
	}
}

package com.gomesluiz.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gomesluiz.cursomc.domain.Cliente;
import com.gomesluiz.cursomc.repositories.ClienteRepository;
import com.gomesluiz.cursomc.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cli = repo.findByEmail(email);
		if(cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(),cli.getEmail(),cli.getSenha(),cli.getPerfis());
	}

}

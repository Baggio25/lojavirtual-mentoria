package com.baggio.lojavirtualbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baggio.lojavirtualbackend.model.Usuario;
import com.baggio.lojavirtualbackend.repository.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findUserByLogin(username);/*Recebe o login do usuario para consulta*/
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não foi encontrado.");
		}
		
		return new User(usuario.getLogin(), usuario.getSenha(), usuario.getAcessos());
	}

}

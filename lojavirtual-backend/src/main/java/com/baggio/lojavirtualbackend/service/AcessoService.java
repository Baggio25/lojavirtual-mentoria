package com.baggio.lojavirtualbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baggio.lojavirtualbackend.model.Acesso;
import com.baggio.lojavirtualbackend.repository.AcessoRepository;

@Service
public class AcessoService {

	@Autowired
	private AcessoRepository acessoRepository;
	
	public Acesso save(Acesso acesso) {
		return acessoRepository.save(acesso);
	}
	
	public void delete(Long id) {
		acessoRepository.deleteById(id);
	}
	
}

package com.baggio.lojavirtualbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baggio.lojavirtualbackend.model.Acesso;
import com.baggio.lojavirtualbackend.service.AcessoService;

@RestController
@RequestMapping(value = "/acessos")
public class AcessoController {
	
	@Autowired
	private AcessoService acessoService;
	
	@PostMapping(value = "/salvarAcesso")
	public ResponseEntity<Acesso> salvar(@RequestBody Acesso acesso) {
		Acesso acessoSalvo = acessoService.save(acesso); 		
		return new ResponseEntity<>(acessoSalvo, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/excluirAcesso/{id}")
	public ResponseEntity<Acesso> excluir(@PathVariable Long id) {
		acessoService.delete(id); 		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

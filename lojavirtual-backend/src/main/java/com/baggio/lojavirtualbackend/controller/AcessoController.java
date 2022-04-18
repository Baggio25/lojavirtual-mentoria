package com.baggio.lojavirtualbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baggio.lojavirtualbackend.model.Acesso;
import com.baggio.lojavirtualbackend.service.AcessoService;

@RestController
public class AcessoController {
	
	@Autowired
	private AcessoService acessoService;
	

	@ResponseBody
	@PostMapping(value = "**/salvarAcesso")
	public ResponseEntity<Acesso> salvar(@RequestBody Acesso acesso) {
		Acesso acessoSalvo = acessoService.save(acesso); 		
		return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
	}
	
	@ResponseBody
	@DeleteMapping(value = "**/excluirAcesso")
	public ResponseEntity<Void> excluir(@RequestBody Acesso acesso) {
		acessoService.delete(acesso.getId()); 		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

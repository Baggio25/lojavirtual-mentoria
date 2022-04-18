package com.baggio.lojavirtualbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baggio.lojavirtualbackend.model.Acesso;
import com.baggio.lojavirtualbackend.service.AcessoService;

@SpringBootTest(classes = LojavirtualBackendApplication.class)
class LojavirtualBackendApplicationTests {


	@Autowired
	private AcessoService acessoService;
		
	@Test
	public void testCadastraAcesso() {
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");
		
		acessoService.save(acesso);
	}

}

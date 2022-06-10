package com.baggio.lojavirtualbackend.security;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*Criar a autenticacao e retornar também a autenticacao JWT*/

@Service
public class JWTTokenAutenticacaoService {
	
	/*Token de validacao de 1 dia*/
	private static final long EXPIRATION_TIME = 86400000;
	
	/*Chave de senha para juntar com o JWT*/
	private static final String SECRET = "lojavirtual";
	
	private static final String TOKEN_PREFIX = "Bearer";
	
	private static final String HEADER_STRING = "Authorization";
	
	/*Gera o token e da a resposta para o cliente com JWT*/
	public void addAuthentication(HttpServletResponse response, String username) throws Exception{
		
		/*Montagem do token*/
		String JWT = Jwts.builder() /*Chama o gerado de token*/
						.setSubject(username) /*Adiciona o user*/
						.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) /*Tempo de expiração*/
						.signWith(SignatureAlgorithm.HS512, SECRET).compact();
	
		/*Ex.: Bearer asdjflasjdfçlaskjdfçkladsjçfljdslçkfjdsçlfjaslçd93408490284239ruefalsdhgçasdkhg*/
		String token = TOKEN_PREFIX + " " + JWT;
		
		/*Retorna para o cliente no cabeçalho*/
		response.addHeader(HEADER_STRING, token);
		
		/*Retorna para o cliente no corpo da resposta*/
		response.getWriter().write("{\"Authorization\": \""+ token + "\"}");
	}
	
}

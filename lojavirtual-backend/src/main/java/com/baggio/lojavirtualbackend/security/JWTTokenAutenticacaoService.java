package com.baggio.lojavirtualbackend.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.baggio.lojavirtualbackend.config.ApplicationContextLoad;
import com.baggio.lojavirtualbackend.model.Usuario;
import com.baggio.lojavirtualbackend.repository.UsuarioRepository;

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
		liberacaoCORS(response);
		
		/*Retorna para o cliente no corpo da resposta*/
		response.getWriter().write("{\"Authorization\": \""+ token + "\"}");
	}
	
	/*Retorna o usuario validado com token, caso nao seja valido retorna null*/
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader(HEADER_STRING);
		if(token != null) {
			String tokenLimpo = token.replace(TOKEN_PREFIX, "").trim();
			
			/*Faz a validação do usuário na requisicao e extrai o usuario*/
			String user = Jwts.parser()
							.setSigningKey(SECRET)
							.parseClaimsJws(tokenLimpo)
							.getBody().getSubject();
			
			if(user != null) {
				Usuario usuarioAutenticado = ApplicationContextLoad
						.getApplicationContext()
						.getBean(UsuarioRepository.class)	
						.findUserByLogin(user);
				
				if(usuarioAutenticado != null) {
					return new UsernamePasswordAuthenticationToken(
							usuarioAutenticado.getLogin(), 
							usuarioAutenticado.getSenha(),
							usuarioAutenticado.getAcessos()
						);
				}
			}
			
		}
		
		liberacaoCORS(response);
		return null;
	}
	
	
	/*Fazendo liberação contra erro de CORS no client ( navegador )*/
	private void liberacaoCORS(HttpServletResponse response) {
		if(response.getHeader("Access-Control-Allow-Origin") == null) {
			response.addHeader("Access-Control-Allow-Origin", "*");
		}
		if(response.getHeader("Access-Control-Allow-Headers") == null) {
			response.addHeader("Access-Control-Allow-Headers", "*");
		}
		if(response.getHeader("Access-Control-Request-Headers") == null) {
			response.addHeader("Access-Control-Request-Headers", "*");
		}
		if(response.getHeader("Access-Control-Allow-Methods") == null) {
			response.addHeader("Access-Control-Allow-Methods", "*");
		}
	}
	
}

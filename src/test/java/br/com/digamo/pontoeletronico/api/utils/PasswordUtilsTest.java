package br.com.digamo.pontoeletronico.api.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtilsTest {

	private static final String SENHA = "12345";
	private final BCryptPasswordEncoder bCryptEncoder = new  BCryptPasswordEncoder();

	@Test
	public void deveVerificarSenhaNula() throws Exception{
		
		assertNull(PasswordUtils.gerarBCript(null));
	}
	
	@Test
	public void deveGerarHashSenha() throws Exception{
		
		String hash = PasswordUtils.gerarBCript(SENHA);
		
		assertTrue(bCryptEncoder.matches(SENHA, hash));
	}
	
	
}

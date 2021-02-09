package br.com.digamo.pontoeletronico.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.digamo.pontoeletronico.api.model.entity.Funcionario;
import br.com.digamo.pontoeletronico.api.model.repository.FuncionarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FuncionarioServiceTest {

	@MockBean
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	private static final String EMAIL = "teste@teste.com";
	private static final String CPF = "90448704080";
	
	@BeforeEach
	public void setUp() throws Exception{
		BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findById(Mockito.anyLong())).willReturn(Optional.ofNullable(new Funcionario()));
		BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByCpfOrEmail(Mockito.anyString(), Mockito.anyString())).willReturn(new Funcionario());
	}

	@Test
	public void deveSalvarFuncionario() {

		Funcionario retorno = this.funcionarioService.salvar(new Funcionario());
		
		assertNotNull(retorno);
	}
	
	@Test
	public void deveBuscarFuncionarioPorCpf() {

		Optional<Funcionario> retorno = this.funcionarioService.buscarPorCpf(CPF);
		
		assertTrue(retorno.isPresent());
	}
	
	
	@Test
	public void deveBuscarFuncionarioPorEmail() {

		Optional<Funcionario> retorno = this.funcionarioService.buscarPorEmail(EMAIL);
		
		assertTrue(retorno.isPresent());
	}
	
	@Test
	public void deveBuscarFuncionarioPorCpfOuEmail() {

		Optional<Funcionario> retorno = this.funcionarioService.buscarPorCpfOuEmail(CPF, EMAIL);
		
		assertTrue(retorno.isPresent());
	}
	
	
}

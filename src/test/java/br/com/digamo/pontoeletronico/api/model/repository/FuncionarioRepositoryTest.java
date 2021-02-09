package br.com.digamo.pontoeletronico.api.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.security.NoSuchAlgorithmException;
import org.junit.runner.RunWith;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.digamo.pontoeletronico.api.model.entity.Empresa;
import br.com.digamo.pontoeletronico.api.model.entity.Funcionario;
import br.com.digamo.pontoeletronico.api.model.enums.PerfilEnum;
import br.com.digamo.pontoeletronico.api.utils.PasswordUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FuncionarioRepositoryTest {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	private static final String EMAIL = "teste@teste.com";
	private static final String CPF = "90448704080";
	
	@BeforeEach
	public void setUp() throws Exception{
		Empresa empresa = this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
	}
	
	@AfterEach
	public final void tearDown() {
		this.funcionarioRepository.deleteAll();
		this.empresaRepository.deleteAll();
	}

	@Test
	public void deveBuscarFuncioarioPorEmail() {
		Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
		assertEquals(EMAIL, funcionario.getEmail());
	}

	@Test
	public void deveBuscarFuncioarioPorCpf() {
		Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
		assertEquals(CPF, funcionario.getCpf());
	}

	@Test
	public void deveBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, "email@invalido.com");

		assertNotNull(funcionario);
	}

	@Test
	public void deveBuscarFuncionarioPorEmailECpfParaCpfInvalido() {
		Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("12345678901", EMAIL);

		assertNotNull(funcionario);
	}
	
	
	@Test
	public void deveBuscarFuncioarioPorEmailOuCpf() {
		Funcionario funcionario1 = this.funcionarioRepository.findByCpfOrEmail(CPF, null);
		assertNotNull(funcionario1);
		
		Funcionario funcionario2 = this.funcionarioRepository.findByCpfOrEmail(null, EMAIL);
		assertNotNull(funcionario2);
		
		Funcionario funcionario3 = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);
		assertNotNull(funcionario3);
		
		Funcionario funcionario4 = this.funcionarioRepository.findByCpfOrEmail(null, null);
		assertNull(funcionario4);
		
	}

	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa Exemplo");
		empresa.setCnpj("60795199000113");
		return empresa;
	}
	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Maria da Silva");
		funcionario.setPerfil(PerfilEnum.ROLE_USER);
		funcionario.setSenha(PasswordUtils.gerarBCript("12345"));
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

}

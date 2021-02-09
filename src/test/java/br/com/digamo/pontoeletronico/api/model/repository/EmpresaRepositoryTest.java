package br.com.digamo.pontoeletronico.api.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.digamo.pontoeletronico.api.model.entity.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpresaRepositoryTest {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String CNPJ = "60795199000113";
	
	@BeforeEach
	public void setUp() throws Exception{
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa Exemplo");
		empresa.setCnpj(CNPJ);
		this.empresaRepository.save(empresa);
	}
	
	@AfterEach
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void deveEncontrarEmpresaPorCnpj() {
		
		Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
		
		assertEquals(CNPJ, empresa.getCnpj());
		
	}
	
}

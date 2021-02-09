package br.com.digamo.pontoeletronico.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

import br.com.digamo.pontoeletronico.api.model.entity.Empresa;
import br.com.digamo.pontoeletronico.api.model.repository.EmpresaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpresaServiceTest {

	@MockBean
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	private static final String CNPJ = "60795199000113";
	
	@BeforeEach
	public void setUp() throws Exception{
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
		
	}
	
	@Test
	public void deveBuscarEmpresaPorCnpj() {

		Optional<Empresa> retorno = this.empresaService.buscarPorCnpj(CNPJ);
		
		assertTrue(retorno.isPresent());
	}
	
	@Test
	public void deveSalvarEmpresa() {
	
		Empresa empresa = this.empresaService.salvar(new Empresa());
		
		assertNotNull(empresa);
	}

	@Test
	public void deveRetornarNullAoTentarSalvarEmpresaNull() {
	
		Empresa empresa = this.empresaService.salvar(null);
		
		assertNull(empresa);
	}
	
}

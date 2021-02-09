package br.com.digamo.pontoeletronico.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.digamo.pontoeletronico.api.model.entity.Empresa;
import br.com.digamo.pontoeletronico.api.model.repository.EmpresaRepository;
import br.com.digamo.pontoeletronico.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository; 
	
	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		log.info("Buscando uma empresa por CNPJ {}", cnpj);
		return Optional.ofNullable(empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa salvar(Empresa empresa) {
		log.info("Salvando uma empresa {}", empresa);
		
		if(empresa == null) {
			log.info("Objeto Empresa é null");
			return null;
		}
		
		return empresaRepository.save(empresa);
	}

}

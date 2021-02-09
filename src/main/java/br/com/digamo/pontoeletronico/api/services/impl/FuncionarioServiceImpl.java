package br.com.digamo.pontoeletronico.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digamo.pontoeletronico.api.model.entity.Funcionario;
import br.com.digamo.pontoeletronico.api.model.repository.FuncionarioRepository;
import br.com.digamo.pontoeletronico.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public Funcionario salvar(Funcionario funcionario) {
		log.info("Salvando um funcionario {}", funcionario);
		
		if(funcionario == null) {
			log.info("Objeto Funcionario é null", funcionario);
			return null;
		}
		
		return this.funcionarioRepository.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		log.info("Buscando um funcionario por CPF {}", cpf);
		return Optional.ofNullable(this.funcionarioRepository.findByCpf(cpf));
		
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		log.info("Buscando um funcionario por E-mail {}", email);
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));

	}

	@Override
	public Optional<Funcionario> buscarPorCpfOuEmail(String cpf, String email) {
		log.info("Buscando um funcionario por CPF {} ou E-mail {}", cpf, email);
		return Optional.ofNullable(this.funcionarioRepository.findByCpfOrEmail(cpf, email));
	}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) {
		log.info("Buscando um funcionario por Id");
		return this.funcionarioRepository.findById(id);
	}


}

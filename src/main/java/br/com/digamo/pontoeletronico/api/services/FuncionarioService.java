package br.com.digamo.pontoeletronico.api.services;

import java.util.Optional;

import br.com.digamo.pontoeletronico.api.model.entity.Funcionario;

public interface FuncionarioService {

	/**
	 * Cadastrar um novo funcionario
	 * 
	 * @param funcionario
	 * @return Funcionario
	 */
	Funcionario salvar(Funcionario funcionario);
	
	/**
	 * Retornar um funcionario a partir de um CPF
	 * 
	 * @param cpf
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * Retornar um funcionario a partir de um E-mail
	 * 
	 * @param email
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * Retornar um funcionario a partir de um Id
	 * 
	 * @param id
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorId(Long id);
	
	/**
	 * Retornar um funcionario a partir de um CPF ou E-mail
	 * 
	 * @param cpf
	 * @param email
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorCpfOuEmail(String cpf, String email);
	
}

package br.com.digamo.pontoeletronico.api.services;

import java.util.Optional;

import br.com.digamo.pontoeletronico.api.model.entity.Empresa;

public interface EmpresaService {

	/**
	 * Retornar uma empresa a partir de um CNPJ
	 * 
	 * @param cnpj
	 * @return Optional<Empresa>
	 */
	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	/**
	 * Cadastrar uma nova empresa
	 * 
	 * @param empresa
	 * @return Empresa
	 */
	Empresa salvar(Empresa empresa);
}

package br.com.digamo.pontoeletronico.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digamo.pontoeletronico.api.model.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	Empresa findByCnpj(String cnpj);
}

package br.com.digamo.pontoeletronico.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digamo.pontoeletronico.api.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	Funcionario findByCpf(String cpf);
	
	Funcionario findByEmail(String email);
	
	Funcionario findByCpfOrEmail(String cpf, String email);
	
}

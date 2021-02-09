package br.com.digamo.pontoeletronico.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digamo.pontoeletronico.api.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}

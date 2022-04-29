package br.com.fiap.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cadastro.model.Candidato;


public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{
	
}
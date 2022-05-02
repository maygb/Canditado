package br.com.fiap.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cadastro.model.LinguagemProgramacao;


public interface LinguagemProgramacaoRepository extends JpaRepository<LinguagemProgramacao, Integer>{

	LinguagemProgramacao findByLinguagem(String linguagem);
	
}
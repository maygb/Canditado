package br.com.fiap.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cadastro.model.Candidato;
import br.com.fiap.cadastro.model.LinguagemProgramacao;


public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{
	
	List<Candidato> findByNome(String nome);

	List<Candidato> findByNomeSocial(String nomeSocial);

	List<Candidato> findByEmail(String email);
	
	List<Candidato> findByCpf(String cpf);

	List<Candidato> findByLinguagem(LinguagemProgramacao linguagem);

	List<Candidato> findByCertificacao(boolean certificacao);
	
}
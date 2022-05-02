package br.com.fiap.cadastro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBL_CANDIDATO")
public class Candidato implements Comparable<Candidato> {

	@Id
	@SequenceGenerator(name = "candidato", sequenceName = "SQ_CANDIDATO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidato")
	private int id;
	
	@Size(max = 30)
	private String nomeSocial;

	@NotBlank(message = "Nome obrigatório!")
	@Size(max = 70)
	private String nome;
	
	@Past
	private LocalDate dataNascimento;

	@NotBlank(message = "CPF obrigatório!")
	@Size(max = 11)
	private String cpf;

	@NotBlank(message = "Telefone obrigatório!")
	@Size(max = 11)
	private String telefone;
	
	@NotBlank(message = "E-mail obrigatório!")
	@Size(max = 60)
	private String email;

	private int experiencia;
	
	private String genero;

	private boolean certificacao;

	@ManyToOne
	private LinguagemProgramacao linguagem;

	
	@Override
	public int compareTo(Candidato outro) {
		if(this.certificacao == outro.isCertificacao()) {
			return Integer.compare(this.experiencia, outro.getExperiencia());
		}
		return Boolean.compare(outro.isCertificacao(), this.certificacao);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public boolean isCertificacao() {
		return certificacao;
	}

	public void setCertificacao(boolean certificacao) {
		this.certificacao = certificacao;
	}

	public LinguagemProgramacao getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(LinguagemProgramacao linguagem) {
		this.linguagem = linguagem;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}

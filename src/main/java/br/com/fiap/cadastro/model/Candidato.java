package br.com.fiap.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TBL_CANDIDATO")
public class Candidato implements Comparable<Candidato> {

	@Id
	@SequenceGenerator(name = "candidato", sequenceName = "SQ_CANDIDATO", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidato")
	private int id;

	@NotBlank(message = "Nome obrigatório!")
	@Size(max = 70)
	private String nome;

	@NotBlank(message = "CPF obrigatório!")
	@Size(max = 11)
	private String cpf;

	@NotBlank(message = "Telefone obrigatório!")
	@Size(max = 11)
	private String telefone;

	private String endereco;

	private String experiencia;

	private boolean certificacao;

	@ManyToOne
	// @NotBlank(message = "Linguagem de programação obrigatório")
	private LinguagemProgramacao linguagem;

	@Override
	public int compareTo(Candidato outro) {
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
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

}

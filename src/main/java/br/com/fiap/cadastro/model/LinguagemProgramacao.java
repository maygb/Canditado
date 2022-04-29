package br.com.fiap.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_LINGUAGEM")
public class LinguagemProgramacao {
	
	@Id
	@SequenceGenerator(name="linguagem", sequenceName="SQ_LINGUAGEM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="linguagem")
	private int id;
	
	private String linguagem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	
}

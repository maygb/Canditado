package br.com.fiap.cadastro.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.cadastro.model.Candidato;
import br.com.fiap.cadastro.repository.CandidatoRepository;
import br.com.fiap.cadastro.repository.LinguagemProgramacaoRepository;

@Controller
@RequestMapping("candidato")
public class CadastroController {
	
	@Autowired
	public CandidatoRepository candidatoRepository;

	@Autowired
	public LinguagemProgramacaoRepository linguagem;

	
	@GetMapping("cadastrar")
	public String abrirFormulario(Candidato candidato, Model model) {
		model.addAttribute("linguagem", linguagem.findAll());
		return "candidato/form";
	}
	
	@PostMapping("cadastrar")
	public String processarForm(@Valid Candidato candidato, BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "candidato/form";
		}
		
		redirect.addFlashAttribute("msg","Cadastrado!");
		candidatoRepository.save(candidato);
		return "redirect:cadastrar";
	}
	
	@GetMapping("listar")
	public String listaCanditados(Model model) {
		List<Candidato> list = candidatoRepository.findAll();
		Collections.sort(list);
		model.addAttribute("candidatos", list);
		return "candidato/lista";
	}
	
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping("cadastrar/teste")
	public Candidato cadastar (@RequestBody Candidato candidato) {
		return candidatoRepository.save(candidato);
	}

	
	@GetMapping("listar/teste")
	public List<Candidato>listar() {
		List<Candidato> lista = candidatoRepository.findAll();
		Collections.sort(lista);
		return lista;
	}
	
}

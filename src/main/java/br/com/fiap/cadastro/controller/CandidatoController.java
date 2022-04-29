package br.com.fiap.cadastro.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.cadastro.model.Candidato;
import br.com.fiap.cadastro.repository.CandidatoRepository;
import br.com.fiap.cadastro.repository.LinguagemProgramacaoRepository;

@RestController
@RequestMapping("candidato")
public class CandidatoController {

	@Autowired
	public CandidatoRepository candidatoRepository;

	@Autowired
	public LinguagemProgramacaoRepository linguagem;
	

	@GetMapping("cadastrar")
	public String abrirFormulario(Candidato canditado, Model model) {
		model.addAttribute("linguagem", linguagem.findAll());
		return "produto/form";
	}

	@PostMapping("cadastrar")
	public String processarForm(@Valid Candidato canditado, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "produto/form";
		}

		redirect.addFlashAttribute("msg", "Cadastrado!");
		candidatoRepository.save(canditado);
		return "redirect:listar";
	}
	
	@GetMapping("listar")
	public String listaCanditados(Model model) {
		List<Candidato> list = candidatoRepository.findAll();
		Collections.sort(list);
		model.addAttribute("canditatos", list);
		return "produto/lista";
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

package br.com.fiap.cadastro.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.cadastro.model.Candidato;
import br.com.fiap.cadastro.model.LinguagemProgramacao;
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
	public String listar(Model model) {		
		List<Candidato> list = candidatoRepository.findAll();
		Collections.sort(list);
		model.addAttribute("candidatos", list);
		return "candidato/lista";
	}
	
	@PostMapping("listar")
	public String buscar(String search, Model model, RedirectAttributes redirect) {

		model.addAttribute("search", search);

		List<Candidato> listNome = candidatoRepository.findByNome(search);
		if(!listNome.isEmpty()) {
			Collections.sort(listNome);
			model.addAttribute("candidatos", listNome);
			return "candidato/lista";
		}
		
		List<Candidato> listNomeSocial = candidatoRepository.findByNomeSocial(search);
		if(!listNomeSocial.isEmpty()) {
			Collections.sort(listNomeSocial);
			model.addAttribute("candidatos", listNomeSocial);
			return "candidato/lista";
		}
		
		List<Candidato> listEmail = candidatoRepository.findByEmail(search);
		if(!listEmail.isEmpty()) {
			Collections.sort(listEmail);
			model.addAttribute("candidatos", listEmail);
			return "candidato/lista";
		}
		
		List<Candidato> listCpf = candidatoRepository.findByCpf(search);
		if(!listCpf.isEmpty()) {
			Collections.sort(listCpf);
			model.addAttribute("candidatos", listCpf);
			return "candidato/lista";
		}
		
		LinguagemProgramacao lingProgram = linguagem.findByLinguagem(search);
		List<Candidato> listLinguagem = candidatoRepository.findByLinguagem(lingProgram);
		if(!listLinguagem.isEmpty()) {
			Collections.sort(listLinguagem);
			model.addAttribute("candidatos", listLinguagem);
			return "candidato/lista";
		}
		
		if(search.equals("Certificado")) {
			boolean b = true;
			List<Candidato> listCertificacao = candidatoRepository.findByCertificacao(b);
			if(!listCertificacao.isEmpty()) {
				Collections.sort(listCertificacao);
				model.addAttribute("candidatos", listCertificacao);
				return "candidato/lista";
			}
		}
		
		if(search.equals("Não Certificado")) {
			boolean b = false;
			List<Candidato> listCertificacao = candidatoRepository.findByCertificacao(b);
			if(!listCertificacao.isEmpty()) {
				Collections.sort(listCertificacao);
				model.addAttribute("candidatos", listCertificacao);
				return "candidato/lista";
			}
		}

		redirect.addFlashAttribute("msg","Informação não encontrada!");
		return "redirect:listar";
	}

	
	@GetMapping("cadastrar/linguagem")
	public String cadastarLinguagens () {
		
		List<String> listNome = new ArrayList<>();
		listNome.add("ActionScript");
		listNome.add("ASP");
		listNome.add("Assembly");
		listNome.add("C");
		listNome.add("C#");
		listNome.add("C++");
		listNome.add("Dart");
		listNome.add("Euphoria");
		listNome.add("Go");
		listNome.add("Java");
		listNome.add("JavaScript");
		listNome.add("Kotlin");
		listNome.add("Lua");
		listNome.add("MATLAB");
		listNome.add("Objective-C");
		listNome.add("Pascal");
		listNome.add("Perl");
		listNome.add("PHP");
		listNome.add("PowerShell");
		listNome.add("Python");
		listNome.add("R");
		listNome.add("Ruby");
		listNome.add("Rust");
		listNome.add("Scala");
		listNome.add("Shell");
		listNome.add("Swift");
		listNome.add("Tcl");
		listNome.add("TypeScript");
		listNome.add("Visual Basic");
		
		for(int i = 0; i<listNome.size(); i++){
			LinguagemProgramacao lp = new LinguagemProgramacao(0, listNome.get(i));	
			linguagem.save(lp);
		}

		return "candidato/linguagem";
	}
	
}
	
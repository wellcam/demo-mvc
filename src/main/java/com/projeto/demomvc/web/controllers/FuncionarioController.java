package com.projeto.demomvc.web.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.demomvc.domain.Funcionario;
import com.projeto.demomvc.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {

		return "/funcionario/cadastro";
	}

	@GetMapping("/listar")
	public String listar() {

		return "/funcionario/lista";
	}
	
	@PostMapping
	public String salvar(Funcionario funcionario) {
		getFuncionarioService().salvar(funcionario);
		
		return "redirect:/funcionarios/cadastrar";
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}
	
}

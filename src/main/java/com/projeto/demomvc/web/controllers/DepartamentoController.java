package com.projeto.demomvc.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.demomvc.domain.Departamento;
import com.projeto.demomvc.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos",getDepService().buscarTodos());
		
		return "/departamento/lista";
	}
	
	@PostMapping("salvar")
	public String salvar(Departamento departamento) {
		getDepService().salvar(departamento);
		
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", getDepService().buscarPorId(id));
		
		return "/departamentos/cadastro"; 
	}
	
	@PostMapping("editar")
	public String editar(Departamento departamento) {
		getDepService().editar(departamento);
		
		return "redirect:/departamentos/cadastrar";
	}
	
	public DepartamentoService getDepService() {
		return departamentoService;
	}
	
}

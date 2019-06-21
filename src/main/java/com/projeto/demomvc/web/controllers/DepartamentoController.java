package com.projeto.demomvc.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("departamentos",departamentoService.buscarTodos());
		
		return "/departamento/lista";
	}
	
	@PostMapping("salvar")
	public String salvar(Departamento departamento, RedirectAttributes redirectAtt) {
		departamentoService.salvar(departamento);
		redirectAtt.addFlashAttribute("success","Departamento inserido com sucesso.");
		
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", departamentoService.buscarPorId(id));
		
		return "/departamento/cadastro"; 
	}
	
	@PostMapping("editar")
	public String editar(Departamento departamento, RedirectAttributes redirectAtt) {
		departamentoService.editar(departamento);
		redirectAtt.addFlashAttribute("success","Departamento editado com sucesso.");
		
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(departamentoService.temCargo(id)) {
			model.addAttribute("fail","Departamento não removido. Possui cargo(s) vinculado(s).");
		} else {
			departamentoService.excluir(id);
			model.addAttribute("success","Departamento excluido com sucesso.");
		}
		
		return listar(model);
	}
	
}

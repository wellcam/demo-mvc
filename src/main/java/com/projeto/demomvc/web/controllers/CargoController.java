package com.projeto.demomvc.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.demomvc.domain.Cargo;
import com.projeto.demomvc.domain.Departamento;
import com.projeto.demomvc.service.CargoService;
import com.projeto.demomvc.service.DepartamentoService;


@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {

		return "/cargo/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes redirectAtt) {
		cargoService.salvar(cargo);
		redirectAtt.addFlashAttribute("success", "Cargo inserido com sucesso.");
		
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {

			cargoService.excluir(id);
			model.addAttribute("success","Cargo excluido com sucesso.");
		
		return listar(model);
	}
	
	@GetMapping("cargos")
	public List<Cargo> listarCargos(){
		return	cargoService.buscarTodos();
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listarDepartamentos(){
		return	departamentoService.buscarTodos();
	}
	
}

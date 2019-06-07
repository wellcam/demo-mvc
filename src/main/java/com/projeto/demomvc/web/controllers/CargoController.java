package com.projeto.demomvc.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.demomvc.domain.Cargo;
import com.projeto.demomvc.service.CargoService;


@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {

		return "/cargo/cadastro";
	}

	@GetMapping("/listar")
	public String listar() {

		return "/cargo/lista";
	}
	
	@PostMapping("salvar")
	public String salvar(Cargo cargo) {
		getCargoService().salvar(cargo);
		
		return "redirect:/cargos/cadastrar";
	}

	public CargoService getCargoService() {
		return cargoService;
	}
	
}

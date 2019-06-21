package com.projeto.demomvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.projeto.demomvc.domain.Departamento;
import com.projeto.demomvc.service.DepartamentoService;

@Component
public class DepartamentoConverter  implements Converter<String, Departamento>{

	@Autowired
	private DepartamentoService departamentoService;

	@Override
	public Departamento convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		return departamentoService.buscarPorId(Long.valueOf(text));
	}
	
}

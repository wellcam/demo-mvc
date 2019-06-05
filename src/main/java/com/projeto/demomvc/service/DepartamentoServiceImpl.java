package com.projeto.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.demomvc.dao.DepartamentoDao;
import com.projeto.demomvc.domain.Departamento;

@Service @Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao departamentoDao;

	@Override
	public void salvar(Departamento departamento) {
		getDepartamentoDao().save(departamento);
	}

	@Override
	public void editar(Departamento departamento) {
		getDepartamentoDao().update(departamento);	
	}

	@Override
	public void excluir(Long id) {
		getDepartamentoDao().delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		return getDepartamentoDao().findById(id);	
	}

	@Override @Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		return getDepartamentoDao().findAll();	
	}

	public DepartamentoDao getDepartamentoDao() {
		return departamentoDao;
	}

	public void setDepartamentoDao(DepartamentoDao departamentoDao) {
		this.departamentoDao = departamentoDao;
	}

}

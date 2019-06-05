package com.projeto.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.demomvc.dao.FuncionarioDao;
import com.projeto.demomvc.domain.Funcionario;

@Service @Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao funcionarioDao;

	@Override
	public void salvar(Funcionario funcionario) {
		getFuncionarioDao().save(funcionario);	
	}

	@Override
	public void editar(Funcionario funcionario) {
		getFuncionarioDao().update(funcionario);	
	}

	@Override
	public void excluir(Long id) {
		getFuncionarioDao().delete(id);	
	}

	@Override @Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return getFuncionarioDao().findById(id);	
	}

	@Override @Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return getFuncionarioDao().findAll();	
	}

	public FuncionarioDao getFuncionarioDao() {
		return funcionarioDao;
	}

	public void setFuncionarioDao(FuncionarioDao funcionarioDao) {
		this.funcionarioDao = funcionarioDao;
	}

}

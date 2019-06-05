package com.projeto.demomvc.dao;

import org.springframework.stereotype.Repository;

import com.projeto.demomvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao{

}

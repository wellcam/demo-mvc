package com.projeto.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.demomvc.dao.CargoDao;
import com.projeto.demomvc.domain.Cargo;

@Service @Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDao cargoDao;

	@Override
	public void salvar(Cargo cargo) {
		getCargoDao().save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		getCargoDao().update(cargo);;
	}

	@Override
	public void excluir(Long id) {
		getCargoDao().delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return getCargoDao().findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return getCargoDao().findAll();
	}

	public CargoDao getCargoDao() {
		return cargoDao;
	}

	public void setCargoDao(CargoDao cargoDao) {
		this.cargoDao = cargoDao;
	}


}

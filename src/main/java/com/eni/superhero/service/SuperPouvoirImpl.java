package com.eni.superhero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eni.superhero.bean.SuperPouvoir;
import com.eni.superhero.dao.SuperPouvoirDAO;

@Service
public class SuperPouvoirImpl implements SuperPouvoirService {
	@Autowired
	SuperPouvoirDAO superPouvoirDAO;

	@Override
	@Transactional
	public SuperPouvoir createOrUptdate(SuperPouvoir superPouvoir) {
		return superPouvoirDAO.save(superPouvoir);
	}

	@Override
	@Transactional
	public void delete(int id) {
		superPouvoirDAO.deleteById(id);
	}

	@Override
	public SuperPouvoir findById(int id) {
		Optional<SuperPouvoir> superPouvoir = superPouvoirDAO.findById(id);
		if(superPouvoir.isPresent()) {
			return superPouvoir.get();
		}else {
			return null;
		}
	}

	@Override
	public List<SuperPouvoir> findall() {
		
		return (List<SuperPouvoir>) superPouvoirDAO.findAll();
	}

	@Override
	public List<SuperPouvoir> findBySuperPouvoirContains(String superPouvoir) {
		return superPouvoirDAO.findBySuperPouvoirContains(superPouvoir);
	}


}

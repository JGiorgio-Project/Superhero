package com.eni.superhero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eni.superhero.bean.Combat;
import com.eni.superhero.dao.CombatDAO;

@Service
public class CombatServiceImpl implements CombatService {
	@Autowired
	CombatDAO combatDAO;
	
	@Override
	@Transactional
	public Combat createOrUptdate(Combat combat) {
		return combatDAO.save(combat);
	}

	@Override
	@Transactional
	public void delete(int id) {
		combatDAO.deleteById(id);
	}

	@Override
	public Combat findById(int id) {
		Optional<Combat> combat = combatDAO.findById(id);
		if(combat.isPresent()) {
			return combat.get();
		}else {
			return null;
		}
	}

	@Override
	public List<Combat> findall() {
		return (List<Combat>) combatDAO.findAll();
	}

}

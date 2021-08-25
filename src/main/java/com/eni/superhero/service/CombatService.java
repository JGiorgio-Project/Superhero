package com.eni.superhero.service;

import java.util.List;

import com.eni.superhero.bean.Combat;

public interface CombatService {
	public Combat createOrUptdate(Combat combat);
	public void delete(int id);
	public Combat findById(int id);
	public List<Combat> findall();
}

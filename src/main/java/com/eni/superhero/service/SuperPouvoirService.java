package com.eni.superhero.service;

import java.util.List;

import com.eni.superhero.bean.SuperPouvoir;

public interface SuperPouvoirService {
	public SuperPouvoir createOrUptdate(SuperPouvoir superPouvoir);
	public void delete(int id);
	public SuperPouvoir findById(int id);
	public List<SuperPouvoir> findall();
	public List<SuperPouvoir> findBySuperPouvoirContains(String superPouvoir);
}

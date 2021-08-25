package com.eni.superhero.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Combat {
	@Id// Clé primaire
	@GeneratedValue(strategy= GenerationType.AUTO) // Auto incrémenté
	private int id;
	private String name;
	@ManyToMany
	private List<SuperHero> superHeros;
	
	public Combat() {
		
	}

	public Combat(String name, List<SuperHero> superHeros) {
		this.name = name;
		this.superHeros = superHeros;
	}

	public Combat(int id, String name, List<SuperHero> superHeros) {
		this.id = id;
		this.name = name;
		this.superHeros = superHeros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SuperHero> getSuperHeros() {
		return superHeros;
	}

	public void setSuperHeros(List<SuperHero> superHeros) {
		this.superHeros = superHeros;
	}

	@Override
	public String toString() {
		return "Combat [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}

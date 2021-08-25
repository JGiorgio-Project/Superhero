package com.eni.superhero.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SuperPouvoir {
	@Id// Clé primaire
	@GeneratedValue(strategy= GenerationType.AUTO) // Auto incrémenté
	private int id;
	private String superPouvoir;
	@ManyToMany(mappedBy="superPouvoirs")
	private List<SuperHero> superHeros;

	public SuperPouvoir() {
		
	}

	public SuperPouvoir(String superPouvoir) {
		super();
		this.superPouvoir = superPouvoir;
	}

	public SuperPouvoir(int id, String superPouvoir) {
		super();
		this.id = id;
		this.superPouvoir = superPouvoir;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSuperPouvoir() {
		return superPouvoir;
	}

	public void setSuperPouvoir(String superPouvoir) {
		this.superPouvoir = superPouvoir;
	}

	@Override
	public String toString() {
		return "SuperPouvoir [id=" + id + ", superPouvoir=" + superPouvoir + "]";
	}
	
	
}

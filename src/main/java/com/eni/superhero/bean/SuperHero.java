package com.eni.superhero.bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SuperHero {
	@Id// Clé primaire
	@GeneratedValue(strategy= GenerationType.AUTO) // Auto incrémenté
	private int id;
	@NotBlank(message="{firstname.notempty}")
	private String firstName;
	private String lastName;
	private String pseudo;
	@ManyToOne
	private Category category;
	@ManyToMany
	private List<SuperPouvoir> superPouvoirs;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	@ManyToMany (mappedBy="superHeros")
	private List<Combat> combats;
	
	public SuperHero() {
		
	}

	public SuperHero(String firstName, String lastName, String pseudo, Category category,
			List<SuperPouvoir> superPouvoirs, LocalDate birthDate, List<Combat> combats) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.pseudo = pseudo;
		this.category = category;
		this.superPouvoirs = superPouvoirs;
		this.birthDate = birthDate;
		this.combats = combats;
	}


	public SuperHero(int id, String firstName, String lastName, String pseudo, Category category,
			List<SuperPouvoir> superPouvoirs, LocalDate birthDate, List<Combat> combats) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pseudo = pseudo;
		this.category = category;
		this.superPouvoirs = superPouvoirs;
		this.birthDate = birthDate;
		this.combats = combats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<SuperPouvoir> getSuperPouvoirs() {
		return superPouvoirs;
	}

	public void setSuperPouvoirs(List<SuperPouvoir> superPouvoirs) {
		this.superPouvoirs = superPouvoirs;
	}

	public List<Combat> getCombats() {
		return combats;
	}

	public void setCombats(List<Combat> combats) {
		this.combats = combats;
	}

	@Override
	public String toString() {
		return "SuperHero [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pseudo=" + pseudo
				+ ", category=" + category + ", birthDate=" + birthDate + "]";
	}

	

}

package com.judah.dndbehind.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "characters")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name is required")
	@Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
	private String name;

	@NotEmpty(message = "Race is required")
	@Size(min = 1, max = 255, message = "Race must be between 1 and 255 characters")
	private String race;

	@NotEmpty(message = "Class is required")
	@Size(min = 1, max = 255, message = "Class must be between 1 and 255 characters")
	private String pClass;

	@NotEmpty(message = "Description is required")
	@Size(min = 5, max = 255, message = "description needs to be more than 5 characters")
	private String description;

	@NotNull
	@Min(value = 0, message = "Level needs to be more than 0")
	private Integer level;

	@NotNull
	@Min(value = 0, message = "Strength needs to be more than 0")
	private Integer strength;

	@NotNull
	@Min(value = 0, message = "Dexterity needs to be more than 0")
	private Integer dexterity;

	@NotNull
	@Min(value = 0, message = "Constitution needs to be more than 0")
	private Integer constitution;

	@NotNull
	@Min(value = 0, message = "Intelligence needs to be more than 0")
	private Integer intelligence;

	@NotNull
	@Min(value = 0, message = "Wisdom needs to be more than 0")
	private Integer wisdom;

	@NotNull
	@Min(value = 0, message = "Charisma needs to be more than 0")
	private Integer charisma;

	@Column(updatable = false)
	private Date created_at;

	@Column(updatable = false)
	private Date updated_at;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Character() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getpClass() {
		return pClass;
	}

	public void setpClass(String pClass) {
		this.pClass = pClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getDexterity() {
		return dexterity;
	}

	public void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getConstitution() {
		return constitution;
	}

	public void setConstitution(Integer constitution) {
		this.constitution = constitution;
	}

	public Integer getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Integer getWisdom() {
		return wisdom;
	}

	public void setWisdom(Integer wisdom) {
		this.wisdom = wisdom;
	}

	public Integer getCharisma() {
		return charisma;
	}

	public void setCharisma(Integer charisma) {
		this.charisma = charisma;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}

}

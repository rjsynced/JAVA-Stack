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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "races")
public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name is required")
	@Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
	private String name;

	@NotNull
	@Min(value = 0, message = "Speed is required")
	@Max(40)
	private Integer speed;

	@NotEmpty(message = "Ability bonus is required")
	@Size(min = 3, max = 100, message = "Ability bonus must be between 3 and 100 characters")
	private String abilityBonus;

	@NotEmpty(message = "Age is required")
	@Size(min = 3, max = 300, message = "Age must be between 3 and 300 characters")
	private String age;

	@NotEmpty(message = "Size is required")
	@Size(min = 5, max = 500, message = "Size must be between 5 and 500 characters")
	private String size;

	@NotEmpty(message = "Languages is required")
	@Size(min = 3, max = 500, message = "Languages must be between 3 and 500 characters")
	private String languages;

	@NotEmpty(message = "Abilities is required")
	@Size(min = 3, max = 1000, message = "Abilities must be between 3 and 1000 characters")
	private String abilities;

	@NotEmpty(message = "Traits is required")
	@Size(min = 5, max = 1000, message = "Traits must be between 5 and 1000 characters")
	private String traits;

	@Column(updatable = false)
	private Date created_at;

	@Column(updatable = false)
	private Date updated_at;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Race() {
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

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public String getAbilityBonus() {
		return abilityBonus;
	}

	public void setAbilityBonus(String abilityBonus) {
		this.abilityBonus = abilityBonus;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	public String getTraits() {
		return traits;
	}

	public void setTraits(String traits) {
		this.traits = traits;
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

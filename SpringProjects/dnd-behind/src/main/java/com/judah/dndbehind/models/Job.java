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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name is required")
	@Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
	private String name;

	@NotEmpty(message = "Description is required")
	@Size(min = 3, max = 255, message = "Description must be between 3 and 255 characters")
	private String description;

	@NotEmpty(message = "Hit Die is required")
	@Size(min = 1, max = 10, message = "Hit Die must be between 1 and 10 characters")
	private String hitDie;

	@NotEmpty(message = "Primary ability is required")
	@Size(min = 1, max = 55, message = "Primary ability must be between 1 and 55 characters")
	private String mainAbility;

	@NotEmpty(message = "Saving throw proficiences is required")
	@Size(min = 1, max = 55, message = "Saving throw proficiences must be between 1 and 55 characters")
	private String saveThrowProf;

	@NotEmpty(message = "Armor and weapons proficiences is required")
	@Size(min = 1, max = 500, message = "Armor and weapon proficiencies must be between 3 and 500 characters")
	private String armorAndWeapons;

	@NotEmpty(message = "Skills is required")
	@Size(min = 1, max = 150, message = "Skills must be between 1 and 150 characters")
	private String skillProf;

	@Column(updatable = false)
	private Date created_at;

	@Column(updatable = false)
	private Date updated_at;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Job() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHitDie() {
		return hitDie;
	}

	public void setHitDie(String hitDie) {
		this.hitDie = hitDie;
	}

	public String getMainAbility() {
		return mainAbility;
	}

	public void setMainAbility(String mainAbility) {
		this.mainAbility = mainAbility;
	}

	public String getSaveThrowProf() {
		return saveThrowProf;
	}

	public void setSaveThrowProf(String saveThrowProf) {
		this.saveThrowProf = saveThrowProf;
	}

	public String getArmorAndWeapons() {
		return armorAndWeapons;
	}

	public void setArmorAndWeapons(String armorAndWeapons) {
		this.armorAndWeapons = armorAndWeapons;
	}

	public String getSkillProf() {
		return skillProf;
	}

	public void setSkillProf(String skillProf) {
		this.skillProf = skillProf;
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

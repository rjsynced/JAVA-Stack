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
@Table(name = "campaigns")
public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name is required")
	@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String name;

	@NotNull
	@Min(0)
	@Max(5)
	private Integer numOfPlayers;

	@NotNull
	@Column(nullable = false)
	private Boolean isPublic;

	@NotNull
	@Column(nullable = false)
	private Boolean isPrivate;

	@NotEmpty(message = "Description is required")
	@Size(min = 5, max = 255, message = "description needs to be more than 5 characters")
	private String description;

	@Column(updatable = false)
	private Date created_at;

	@Column(updatable = false)
	private Date updated_at;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Campaign() {
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

	public Integer getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(Integer numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

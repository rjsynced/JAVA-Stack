package com.judah.bookclub.models;

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
@Table(name="books")
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Title is required")
	@Size(min=2, max=30, message="Title must be between 2 and 30 characters")
	private String title;
	
	@NotEmpty(message="Author is required")
	@Size(min=2, max=15, message="Author's name must be between 2 and 15 characters")
	private String authorName;
	
	@NotEmpty(message="Description is required")
	@Size(min=8, max=128, message="Description must be between 8 and 128 characters")
	private String description;
	
	
	@Column(updatable = false)
    private Date created_at;
	
    @Column(updatable = false)
    private Date updated_at;
    
    @PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public Book() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	
	
}

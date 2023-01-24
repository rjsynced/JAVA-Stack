package com.judah.yogaplatform.models;

import java.time.LocalTime;
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
@Table(name="courses")
public class Course {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Name is required")
	@Size(min=2, max=15, message="Name must be between 2 and 15 characters")
	private String name;
	
	@NotEmpty(message="Weekday is required")
	@Size(min=3, max=15, message="Weekday must be between 2 and 10 characters")
	private String weekday;
	
	@NotNull
	@Min(value=0, message="Price needs to be more than 0")
	private Integer price;
	
	@NotNull
	@Column(name = "local_time", columnDefinition = "TIME")
	private LocalTime time;
	
	@NotNull
	@Size(min=5, max= 200, message="description needs to be more than 5 characters")
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
	
	private String teacher;
	
	public Course() {}

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

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	

	
}

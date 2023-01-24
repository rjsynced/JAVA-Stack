package com.judah.dojosandninjas.models;

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

@Entity
@Table(name="ninjas")
public class Ninja {
	
	//attributes
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String firstName;
    
    @NotEmpty
    private String lastName;
    
    private int age;
    
    @Column(updatable=false)
    private Date created_at;
    private Date updated_at;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
	
	// zero argument constructor
	public Ninja() {}
	// constructor
	public Ninja(Long id, String firstName, String lastName, int age, Date created_at,
			Date updated_at, Dojo dojo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.dojo = dojo;
	}
	
	// getters and setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Dojo getDojo() {
		return dojo;
	}
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
}

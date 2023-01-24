package com.judah.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	// attributes
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min=1, max= 20, message="name needs to be more than 1 character")
	private String name;
	
	@NotNull
	@Size(min=3, max= 200, message="vendor needs to be more than 3 characters")
	private String vendor;
	
	
	@Min(value=0, message="amount needs to be more than 0")
	@NotNull
	private Integer amount;
	
	@NotNull
	@Size(min=5, max= 200, message="description needs to be more than 5 characters")
	private String description;
	
	// This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	

	public Expense() {}

	public Expense(
			@NotNull @Size(min = 1, max = 20, message = "name needs to be more than 1 character") String name,
			@NotNull @Size(min = 3, max = 200, message = "vendor needs to be more than 3 characters") String vendor,
			@Min(value = 0, message = "amount needs to be more than 0") @NotNull Integer amount,
			@NotNull @Size(min = 5, max = 200, message = "description needs to be more than 5 characters") String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public Expense(Long id,
			@NotNull @Size(min = 1, max = 20, message = "name needs to be more than 1 character") String name,
			@NotNull @Size(min = 3, max = 200, message = "vendor needs to be more than 3 characters") String vendor,
			@Min(value = 0, message = "amount needs to be more than 0") @NotNull Integer amount,
			@NotNull @Size(min = 5, max = 200, message = "description needs to be more than 5 characters") String description) {
		this.id = id;
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
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

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}

package com.burgertracker.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class BourgerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=2,message="Name must be at least 2 caracters!!!")
	private String name;
	@Size(min=2,message="Name of Resto must be at least 2 caracters!!!")
	private String resto;
	@NotNull(message="the rating must be not empty ")
	@Min(value = 0, message = "Rate must be at least 0")
    @Max(value = 5, message = "Rate must be no more than 5")
	private Integer rate;
	@Size(min=2,message="Note must be at least 2")
	private String note;
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
		this.updatedAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	//empty constracteur
	public BourgerModel() {}
	// getters and setters
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

	public String getResto() {
		return resto;
	}

	public void setResto(String resto) {
		this.resto = resto;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
	
	
}

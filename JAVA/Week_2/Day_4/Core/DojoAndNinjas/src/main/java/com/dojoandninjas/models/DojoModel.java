package com.dojoandninjas.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class DojoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=2,message="Name must be at least 2 caracters!!!")
	private String name;
	@Column(updatable=false)
	private Date createdAt;	
	private Date updatedAt;
	@OneToMany(mappedBy="dojo",cascade=CascadeType.ALL)
	List<NinjaModel> ninjas;
	@PrePersist
	protected void onCreate() {
		this.createdAt=new Date();
		this.updatedAt=new Date();
}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt=new Date();
	}
	//empty constractor
		public DojoModel() {}
		// Getters and Setters
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
		public List<NinjaModel> getNinjas() {
			return ninjas;
		}
		public void setNinjas(List<NinjaModel> ninjas) {
			this.ninjas = ninjas;
		}
		
}
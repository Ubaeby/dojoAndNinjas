package com.codingdojo.dojoninja.models;
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

	@Entity
	@Table(name="ninjas")
	public class Ninja {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String fname;
		private String lname;
		private Integer age;
		@Column(updatable = false)
		private Date createdAt;
		private Date updatedAt;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="dojo_id")
		private Dojo dojo;
		
		public Ninja() {}
		
		public Ninja(String fname, String lname, Integer age, Dojo dojo) {
			this.fname = fname;
			this.lname = lname;
			this.age = age;
			this.dojo = dojo;
		}
		
		public Dojo getDojo() {
			return dojo;
		}

		public void setDojo(Dojo dojo) {
			this.dojo = dojo;
		}

		public Ninja(Long id, String fname, String lname, Integer age, Dojo dojo) {
			this.id = id;
			this.fname = fname;
			this.lname	= lname;
			this.age = age;
			this.dojo = dojo;
		}
				
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
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
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
		
	}

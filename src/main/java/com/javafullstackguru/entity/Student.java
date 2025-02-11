package com.javafullstackguru.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Student {
	
	@Id
	private Integer id;
	
	private String name;
	
	private String email;
	
	private Long Phone_Number;
	
	public Student() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(Long phone_Number) {
		Phone_Number = phone_Number;
	}

	public Student(Integer id, String name, String email, Long phone_Number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Phone_Number = phone_Number;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", Phone_Number=" + Phone_Number + "]";
	}
	
	
	
}

package com.luciano.felipe.hruser.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String role_name;

	public Role() {

	}

	public Role(Long id, String role_name) {

		this.id = id;
		this.role_name = role_name;
	}

	public Long getId() {
		return id;
	}

	public String getRoleName() {
		return role_name;
	}

	public void setName(Long id) {
		this.id = id;
	}

	public void setRoleName(String role_name) {
		this.role_name = role_name;
	}
}

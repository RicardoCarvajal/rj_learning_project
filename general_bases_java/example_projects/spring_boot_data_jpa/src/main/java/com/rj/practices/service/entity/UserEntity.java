package com.rj.practices.service.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private byte disabled;

	private String email;

	private byte locked;

	private String password;

	public byte getDisabled() {
		return this.disabled;
	}

	public void setDisabled(byte disabled) {
		this.disabled = disabled;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getLocked() {
		return this.locked;
	}

	public void setLocked(byte locked) {
		this.locked = locked;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
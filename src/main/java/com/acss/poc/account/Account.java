package com.acss.poc.account;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "m_account")
public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;

	private Set<UserRole> authorities;

    protected Account() {

	}
	
	public Account(String username, String password, Set<UserRole> authorities) {
		this.username = username;
		this.password = password;
		this.setAuthorities(authorities);
	}
	
	public void setId(Long id){
		this.id=id;
	}
	
	public Long getId() {
		return id;
	}

    public String getusername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserRole> authorities) {
		this.authorities = authorities;
	}

}

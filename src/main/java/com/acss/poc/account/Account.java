package com.acss.poc.account;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.SpringSecurityCoreVersion;

import com.acss.poc.role.UserRole;



@Entity
@Table(name = "m_account")
public class Account implements java.io.Serializable {
	
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	private Set<UserRole> authorities;

    public Account() {
    	authorities = new HashSet<UserRole>();
	}
	
	public Account(String username, String password, Set<UserRole> authorities) {
		this.username = username;
		this.password = password;
		this.setAuthorities(authorities);
	}
	
	
	public boolean isNew(){
		return (this.id == null);
	}
	
	public void addRole(UserRole newRole){
		this.authorities.add(newRole);
	}
	
	/*
	 * Getters and Setters below.
	 *  
	 */
	public void setId(Long id){
		this.id=id;
	}
	
	public Long getId() {
		return id;
	}

    public String getUsername() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

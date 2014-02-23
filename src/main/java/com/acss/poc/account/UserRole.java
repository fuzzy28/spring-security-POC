package com.acss.poc.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

@Entity
@Table(name = "m_account_role")
public class UserRole implements GrantedAuthority{
	
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "role")
	private String role;
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getAuthority() {
		return role;
	}

}

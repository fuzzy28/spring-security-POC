package com.acss.poc.account;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class AccountRepository {
	protected static Logger logger = Logger.getLogger("dao");
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public Account save(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		//entityManager.persist(account);
		return account;
	}
	
	public Account findByUserName(String username) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", username);
			
			Account account  = (Account) this.namedParameterJdbcTemplate.queryForObject(
	                "SELECT id,username, password ,role FROM m_account WHERE username = :username",
	                params,
	                new AccountRowMapper());
			params.put("m_account_id", account.getId());
			
			List<UserRole> authorities = 
					this.namedParameterJdbcTemplate.query(
					"SELECT role from m_account_roles where m_account_id = :m_account_id", 
					params,ParameterizedBeanPropertyRowMapper.newInstance(UserRole.class));
			
			account.setAuthorities(new HashSet<UserRole> (authorities));
			logger.debug("user successfully retrieved");
			return account;
		} catch (PersistenceException e) {
			logger.debug(e.getMessage());
			return null;
		}
	}
}

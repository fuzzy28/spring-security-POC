package com.acss.poc.account;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.acss.poc.role.RoleRepository;
import com.acss.poc.role.UserRole;

@Repository
@Transactional(readOnly = true)
public class AccountRepository implements IAccountRepository{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private RoleRepository roleRepository;
	
	private SimpleJdbcInsert insertAccount;
	
	public AccountRepository(){}
	
	@Autowired
	public AccountRepository(DataSource dataSource,RoleRepository roleRepository) {
		
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.insertAccount = new SimpleJdbcInsert(dataSource).withTableName("m_account").usingGeneratedKeyColumns("id");
		this.roleRepository = roleRepository;
	}
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public Account save(Account account) throws  DataAccessException,BadSqlGrammarException{
		BeanPropertySqlParameterSource userParam = new BeanPropertySqlParameterSource(account);
		
		if (account.isNew()) {
			
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			
            Number newKey = this.insertAccount.executeAndReturnKey(userParam);
            account.setId(newKey.longValue());
            //Save a default row for the user.
            UserRole defaultRole = roleRepository.save(new UserRole(account.getUsername(),"ROLE_USER")); 
			//add role to account for presentation.
			account.addRole(defaultRole);
			
        } else {
            this.namedParameterJdbcTemplate.update(
                    "UPDATE m_account SET first_name=:firstName, last_name=:lastName, email=:email, " +
                            "password=:password, username=:username WHERE id=:id",
                            userParam);
        }
		return account;
	}
	
	public Account findByUserName(String username) throws DataAccessResourceFailureException{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", username);
			Account account = null;

			 account = (Account) this.namedParameterJdbcTemplate.queryForObject(
	                "SELECT * FROM m_account WHERE username = :username",
	                params,
	                ParameterizedBeanPropertyRowMapper.newInstance(Account.class));
			
			List<UserRole> authorities = 
					this.namedParameterJdbcTemplate.query(
					"SELECT role from m_account_roles where username = :username", 
					params,ParameterizedBeanPropertyRowMapper.newInstance(UserRole.class));
			
			account.setAuthorities(new HashSet<UserRole> (authorities));
			
			
			return account;
	}

	public boolean removeAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Account> query(AccountSpecification specification) {
		// TODO Auto-generated method stub
		return null;
	}
}

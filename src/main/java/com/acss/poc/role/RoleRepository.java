package com.acss.poc.role;

import java.util.HashMap;
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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public class RoleRepository {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcInsert insertRole;
	
	public RoleRepository(){}
	
	@Autowired
	public RoleRepository(DataSource dataSource) {
		
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.insertRole  = new SimpleJdbcInsert(dataSource).withTableName("m_account_roles").usingGeneratedKeyColumns("id");
	}
	
	@Transactional
	public UserRole save(UserRole role) throws  DataAccessException,BadSqlGrammarException{
		BeanPropertySqlParameterSource roleParam = new BeanPropertySqlParameterSource(role);
		
		if (role.isNew()) {          
            //create a default role as user
			Number roleId = this.insertRole.executeAndReturnKey(roleParam);			
			role.setId(roleId.longValue());	
        } else {
            this.namedParameterJdbcTemplate.update(
                    "UPDATE m_account_roles SET role=:role, username=:username WHERE id=:id",
                    roleParam);
        }
		return role;
	}
	

	public UserRole findById(Long id) throws DataAccessResourceFailureException{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", id);
			UserRole role = null;
			try{
				role = (UserRole) this.namedParameterJdbcTemplate.queryForObject(
	                "SELECT * FROM m_account_roles WHERE id = :id",
	                params,
	                ParameterizedBeanPropertyRowMapper.newInstance(UserRole.class));
			params.put("id", id);
			
			}catch(BadSqlGrammarException e){
				throw new DataAccessResourceFailureException(e.getMessage());
			}
			
			return role;
	}
}

package com.autumn.db.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBDao {

	@Autowired
	private JdbcTemplate jt;
	
	@Autowired
	private String dbSql;
	
	public int initDb() {
		return jt.update(dbSql);
	}
	
	public void update(String sql) {
		jt.execute(sql);
	}
}

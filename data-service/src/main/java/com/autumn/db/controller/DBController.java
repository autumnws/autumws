/**
 * 
 */
package com.autumn.db.controller;

import java.util.List;




import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autumn.db.dao.DBDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.micrometer.core.annotation.Timed;

/**
 * @author Eazy Bytes
 *
 */

@RestController
@RequestMapping("/db")
public class DBController {
	
	private static final Logger logger = LoggerFactory.getLogger(DBController.class);

	@Autowired
	private DBDao dao;
	
	@GetMapping("/initdb")
	public String initDb() {
		dao.initDb();
		return "Hello, Welcome to Autumn DB has been intialized";
	}

	@PostMapping("/update")
	public String update(@RequestBody String query) {
		dao.update(query);
		return "Hello, Welcome to Autumn DB has been intialized";
	}
	
	
}

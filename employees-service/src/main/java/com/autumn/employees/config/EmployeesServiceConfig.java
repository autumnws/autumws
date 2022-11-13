/**
 * 
 */
package com.autumn.employees.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Eazy Bytes
 *
 */
@Configuration
@ConfigurationProperties(prefix = "employees")
public class EmployeesServiceConfig {

	/* private String msg; */
	 private String buildVersion;
		/*
		 * private Map<String, String> mailDetails; private List<String> activeBranches;
		 */

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	 
}

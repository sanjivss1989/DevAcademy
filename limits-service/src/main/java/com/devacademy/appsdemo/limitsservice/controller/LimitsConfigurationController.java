/**
 * 
 */
package com.devacademy.appsdemo.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devacademy.appsdemo.limitsservice.bean.LimitConfiguration;
import com.devacademy.appsdemo.limitsservice.configuration.Configuration;

/**
 * @author server
 *
 */
@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations()
	{
		return new LimitConfiguration(config.getMaximum(), config.getMinimum());
	}

}

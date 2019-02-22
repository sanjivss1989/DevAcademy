/**
 * 
 */
package com.devacademy.appsdemo.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devacademy.appsdemo.currencyexchangeservice.bean.ExchangeValue;

/**
 * @author server
 *
 */

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;

	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
	{
		ExchangeValue ex = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		ex.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return ex;
	}
	
}

/**
 * 
 */
package com.devacademy.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devacademy.demo.model.Employee;

/**
 * @author server
 *
 */
@RestController
@ComponentScan("com.devacademy.demo")
public class EmployeeController {
	
	@GetMapping(path = "/viewall")
	public List<Employee> getEmployee()
	{
		//All Employere details
		List<Employee> eList = new ArrayList<Employee>();
		eList.add(new Employee("8043652", "Sanjib", "sanjivsworld66@gmail.com"));
		eList.add(new Employee("8043653", "John", "JohnyS66@gmail.com"));
		eList.add(new Employee("8043654", "JDavid", "JDavid6@gmail.com"));
		eList.add(new Employee("8043655", "William", "William6@gmail.com"));
		return eList;
		
	}
	
	

}

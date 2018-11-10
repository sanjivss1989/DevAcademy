/**
 * 
 */
package com.devacademy.appsdemo.springbootrest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devacademy.appsdemo.springbootrest.model.Employee;
import com.devacademy.appsdemo.springbootrest.service.EmployeeService;

/**
 * @author server
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;

	@PostMapping(path = "/api/save")
	public ResponseEntity<Object> saveEmployee(Employee emp)
	{
		Employee emp1 = empService.saveEmployee(emp);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(emp1.getId())
		.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "api/viewall")
	public List<Employee> retrieveEmployees()
	{
		return empService.retrieveEmployees();
	}
	
	
	@GetMapping(path = "/api/get/{id}")
	public Employee getEmployee(@PathVariable(name = "id")Long id)
	{
		return empService.getEmployee(id);
	}
	
	@PutMapping(path = "/api/update/{id}")
	public void updateEmployee(@RequestBody Employee emp, @PathVariable(name = "id") Long id)
	{
		Employee emp1 = getEmployee(id);
		if(null!=emp1)
		{
			empService.updateEmployee(emp);
		}
		
	}
	
	@DeleteMapping(path = "/api/delete/{id}")
	public void deleteEmployee(@PathVariable(name = "id")Long id)
	{
		Employee emp1 = getEmployee(id);
		if(null!=emp1)
		{
			empService.deleteEmployee(id);
		}
	}
}

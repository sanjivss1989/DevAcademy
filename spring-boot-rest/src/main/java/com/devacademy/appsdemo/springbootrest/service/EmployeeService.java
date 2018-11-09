/**
 * 
 */
package com.devacademy.appsdemo.springbootrest.service;

import java.util.List;

import com.devacademy.appsdemo.springbootrest.model.Employee;

/**
 * @author server
 *
 */
public interface EmployeeService {
	
	public void saveEmployee(Employee emp);
	
	public List<Employee> retrieveEmployees();
	
	
	public Employee getEmployee(Long id);
	
	
	public void updateEmployee(Employee emp);
	
	
	public void deleteEmployee(Long id);
	
	

}

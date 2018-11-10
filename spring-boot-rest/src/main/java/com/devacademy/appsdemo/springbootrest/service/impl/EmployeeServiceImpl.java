/**
 * 
 */
package com.devacademy.appsdemo.springbootrest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devacademy.appsdemo.springbootrest.model.Employee;
import com.devacademy.appsdemo.springbootrest.repository.EmployeeRepository;
import com.devacademy.appsdemo.springbootrest.service.EmployeeService;

/**
 * @author server
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Employee emp1 = empRepo.save(emp);
		return emp1;
	}

	@Override
	public List<Employee> retrieveEmployees() {
		// TODO Auto-generated method stub
		List<Employee> eList = new ArrayList<Employee>();
		eList = empRepo.findAll();
		return eList;
	}

	@Override
	public Employee getEmployee(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional = empRepo.findById(id);
		Employee emp = optional.get();
		return emp;
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
	}

}

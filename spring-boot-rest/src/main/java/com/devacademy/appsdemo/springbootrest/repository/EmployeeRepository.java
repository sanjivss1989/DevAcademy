/**
 * 
 */
package com.devacademy.appsdemo.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devacademy.appsdemo.springboot.model.Employee;

/**
 * @author server
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

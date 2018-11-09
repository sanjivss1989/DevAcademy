/**
 * 
 */
package com.devacademy.appsdemo.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devacademy.appsdemo.springbootrest.model.Employee;

/**
 * @author server
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

package com.aman.springbootdemo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aman.springbootdemo.model.Employee;
import com.aman.springbootdemo.model.Employees;
import com.aman.springbootdemo.repository.EmployeeRepository;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeDao;

	@GetMapping(path = "/", produces = "application/json")
	public Employees getEmployees() {
		return employeeDao.getAllEmployees();
	}

	@PostMapping(path = "/addemployee", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(Employee employee) {
		// Generate resource id
		int id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
		employee.setId(id);
		// add resource
		employeeDao.addEmployee(employee);

		// Create resource location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}

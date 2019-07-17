package com.aman.springbootdemo.repository;

import org.springframework.stereotype.Repository;

import com.aman.springbootdemo.model.Employee;
import com.aman.springbootdemo.model.Employees;

@Repository
public class EmployeeRepository {
	private static Employees list = new Employees();

	static {
		list.getEmployeeList().add(new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"));
		list.getEmployeeList().add(new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"));
		list.getEmployeeList().add(new Employee(3, "David", "Kameron", "titanic@gmail.com"));
	}

	public Employees getAllEmployees() {
		return list;
	}

	public void addEmployee(Employee employee) {
		list.getEmployeeList().add(employee);
	}
}

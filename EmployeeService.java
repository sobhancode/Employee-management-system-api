package com.techm.Employee_Management_System.service;

import java.util.List;
import java.util.Optional;

import com.techm.Employee_Management_System.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	public String removeEmployee(int id);
	public String updateEmployee(Employee employee, int id);
	public Optional<Employee> findById(int id);
	public List<Employee> getAllEmployee();
}

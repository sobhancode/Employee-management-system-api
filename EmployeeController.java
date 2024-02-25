package com.techm.Employee_Management_System.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.Employee_Management_System.model.Employee;
import com.techm.Employee_Management_System.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl service;
	@GetMapping("/home")
	public String home() {
		return "Welcome susobhan";
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee savedEmp = service.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmp,HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable int id){
		service.removeEmployee(id);
		return new ResponseEntity<String>("Remove successfully",HttpStatus.ACCEPTED);
	}
	@GetMapping("/findEmp/{id}")
	public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id){
		Optional<Employee> emp = service.findById(id);
		return new ResponseEntity<Optional<Employee>>(emp,HttpStatus.ACCEPTED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> listOfEmployee(){
		List<Employee> allEmployee = service.getAllEmployee();
		return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.ACCEPTED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody  Employee employee, @PathVariable int id){ 
		String updateEmployee = service.updateEmployee(employee, id);
		return  ResponseEntity.ok(updateEmployee);
	}
}

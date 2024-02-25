package com.techm.Employee_Management_System.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.Employee_Management_System.model.Employee;
import com.techm.Employee_Management_System.repo.EmployeeRepository;
import com.techm.Employee_Management_System.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repository.save(employee);
	}

	@Override
	public String removeEmployee(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return "Employee Deleted successfully";
	}

	@Override
	public String updateEmployee(Employee employee, int id) {
	    Optional<Employee> optionalEmployee = repository.findById(id);
	    if(optionalEmployee.isPresent()) {
	        Employee existingEmployee = optionalEmployee.get();
	        existingEmployee.setName(employee.getName());
	        existingEmployee.setAge(employee.getAge());
	        existingEmployee.setState(employee.getState());
	        existingEmployee.setType(employee.getType());
	        existingEmployee.setSalary(employee.getSalary());
	        repository.save(existingEmployee);
	        return "Employee Updated successfully";
	    } else {
	        return "Employee not found";
	    }
	}


	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = repository.findById(id);
		if(emp.isPresent()) {
			return emp;
		}
		else {
		return null;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
}

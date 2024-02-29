package com.infob.dummygradle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infob.dummygradle.entity.Employee;
import com.infob.dummygradle.repository.EmployeeRepository;
import com.infob.dummygradle.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Employee saveEmp(Employee emp) {
		return empRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

	@Override
	public void deleteEmpById(int id) throws Exception {
		Employee emp = empRepo.getOne(id);
		empRepo.delete(emp);
		
//		Employee emp = empRepo.findOne(id).orElseThrow(() -> new Exception("Employee not found with id : " + id));
//		empRepo.delete(emp);
	}

	@Override
	public Employee updateEmp(Employee emp, int id) throws Exception{
		Employee employee = empRepo.getOne(id);
//		Employee employee = empRepo.findById(id).orElseThrow(() -> new Exception("Employee not found with id : " + id));
		employee.setEmpId(emp.getEmpId());
		employee.setName(emp.getName());
		employee.setMobileNumber(emp.getMobileNumber());
		employee.setEmailId(emp.getEmailId());
		return empRepo.save(employee);
	}

}

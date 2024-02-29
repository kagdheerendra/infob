package com.infob.dummygradle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infob.dummygradle.entity.Employee;


@Service
public interface EmployeeService {

	public Employee saveEmp(Employee emp);
	public List<Employee> getAllEmp();
	public void deleteEmpById(int id) throws Exception;
	public Employee updateEmp(Employee emp, int id) throws Exception;
}

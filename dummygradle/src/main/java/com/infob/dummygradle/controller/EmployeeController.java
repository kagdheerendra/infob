package com.infob.dummygradle.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infob.dummygradle.entity.Employee;
import com.infob.dummygradle.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(empService.saveEmp(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmp(){
		return new ResponseEntity<List<Employee>>(empService.getAllEmp(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable("id") int id, @RequestBody Employee emp){
		try {
			return new ResponseEntity<Employee> (empService.updateEmp(emp, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id){
		try {
			empService.deleteEmpById(id);
			return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

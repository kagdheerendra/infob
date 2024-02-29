package com.infob.dummygradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infob.dummygradle.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

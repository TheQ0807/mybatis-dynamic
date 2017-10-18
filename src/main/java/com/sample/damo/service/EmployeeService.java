package com.sample.damo.service;

import java.util.List;

import com.sample.damo.vo.Criteria;
import com.sample.damo.vo.Employee;

public interface EmployeeService {

	List<Employee> searchEmployees(Employee employee);
	List<Employee> findEmployees(Criteria c);
}

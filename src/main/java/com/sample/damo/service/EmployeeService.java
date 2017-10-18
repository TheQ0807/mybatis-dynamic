package com.sample.damo.service;

import java.util.List;
import java.util.Map;

import com.sample.damo.vo.Criteria;
import com.sample.damo.vo.Employee;

public interface EmployeeService {

	List<Employee> searchEmployees(Employee employee);
	List<Employee> findEmployees(Criteria c);
	List<Employee> getEmployees(Map<String , Object> search);
	List<Map<String, Object>> takeEmployees(Map<String , Object> search);
	List<Employee> fetchEmployees(Criteria c);
	
	void updateEmployee(Employee employee);
}

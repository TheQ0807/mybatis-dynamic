package com.sample.damo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.damo.exception.EmptyResultException;
import com.sample.damo.mappers.EmployeeMapper;
import com.sample.damo.vo.Criteria;
import com.sample.damo.vo.Employee;

@Service
public class EmployeeSerivceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> searchEmployees(Employee employee){
		if(employee == null) {
			return employeeMapper.getAllEmployees();
		}
		List<Employee> employees = employeeMapper.searchEmployees(employee);
		if(employees.isEmpty()) {
			throw new EmptyResultException("조회결과가 존재하지 않습니다.");
		}
		return employees;
	}

	public List<Employee> findEmployees(Criteria c) {
		if(c == null) {
			throw new IllegalArgumentException("Criteria는 null을 허용하지 않습니다.");
		}
		//List<Employee> employees = employeeMapper.findEmployees(c);
		//return employees;
		return employeeMapper.findEmployees(c);
	}
	
	public List<Employee> getEmployees(Map<String, Object> search) {
		if(search == null) {
			throw new IllegalArgumentException("Map은 null을 허용하지 않습니다.");
		}
		//List<Employee> employees = employeeMapper.findEmployees(c);
		//return employees;
		return employeeMapper.getEmployees(search);
	}
	
	
	
}

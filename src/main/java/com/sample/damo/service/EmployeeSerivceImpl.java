package com.sample.damo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.damo.exception.EmptyResultException;
import com.sample.damo.mappers.EmployeeMapper;
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
}

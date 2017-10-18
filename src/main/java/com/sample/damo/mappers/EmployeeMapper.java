package com.sample.damo.mappers;

import java.util.List;

import com.sample.damo.vo.Criteria;
import com.sample.damo.vo.Employee;

public interface EmployeeMapper {

	List<Employee> getAllEmployees();
	List<Employee> searchEmployees(Employee employee);
	List<Employee> findEmployees(Criteria c);
}

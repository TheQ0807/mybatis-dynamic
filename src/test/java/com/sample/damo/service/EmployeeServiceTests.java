package com.sample.damo.service;

import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.damo.vo.Criteria;
import com.sample.damo.vo.Employee;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/META-INF/spring/app-context.xml"})
public class EmployeeServiceTests {

	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void testConfig() {
		//assertThat(employeeService, notNullValue());
		assertNotNull(employeeService);
	}
	
	@Test
	public void testSearchEmployees() {
		List<Employee> result = null;
		result = employeeService.searchEmployees(null);
		assertEquals(107, result.size());
		assertThat(result.size(), is(107));
		
		Employee employee = new Employee();
		employee.setDepartmentId(new Long(80));
		result = employeeService.searchEmployees(employee);
		assertEquals(34, result.size());
		
		employee.setDepartmentId(new Long(80));
		employee.setJobId("SA_MAN");
		result = employeeService.searchEmployees(employee);
		assertEquals(5, result.size());
	}
	
	@Test
	public void testFindEmployees() {
		Criteria c = new Criteria();
		c.setOpt("job");
		c.setKeyword("SA_MAN");
		
		List<Employee> result = employeeService.findEmployees(c);
		assertEquals(5, result.size());
	}
	
	
	
}

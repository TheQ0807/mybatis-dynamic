package com.sample.damo.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Ignore;
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

	@Ignore
	@Test
	public void testConfig() {
		//assertThat(employeeService, notNullValue());
		assertNotNull(employeeService);
	}
	
	@Ignore
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
	
	@Ignore
	@Test
	public void testFindEmployees() {
		Criteria c = new Criteria();
		c.setOpt("job");
		c.setKeyword("SA_MAN");
		
		List<Employee> result = employeeService.findEmployees(c);
		assertEquals(5, result.size());
	}
	
	@Ignore
	@Test
	public void testGetEmployees() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dept", 80);
		
		List<Employee> result = employeeService.getEmployees(map);
		assertEquals(34, result.size());
	}
	
	@Ignore
	@Test
	public void testTakeEmployees() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 100);
		
		List<Map<String, Object>> result = employeeService.takeEmployees(map);
		assertEquals(1, result.size());
		
		System.out.println(result);
		
		for(Map<String, Object> emp : result) {
			System.out.println(emp.get("EMPLOYEE_ID"));
			System.out.println(emp.get("JOB_ID"));
			System.out.println(emp.get("SALARY"));
		}
	} 
	
	
	@Test
	public void testFeetchEmployees() {
		Criteria c  = new Criteria();
		c.setDepts(Arrays.asList(10,20,30,40));
					// 어레이쓴이유는 리스트객체를 생성하기 위해서다.
		List<Employee> result = employeeService.fetchEmployees(c);
		assertEquals(11, result.size());
	}
	
	@Test
	public void testUpdateEmployee() {
		Employee e = new Employee();
		e.setId(new Long(100));
		e.setFirstName("HONG");
		e.setLastName("Gildong");
		
		employeeService.updateEmployee(e);
		
	} 
}

package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.Employee;
import com.revature.repositories.EmployeeDAOImpl;
import com.revature.service.EmployeeService;

public class ServiceTests {
	
	// Our Service Layer depends on the DAO
	private EmployeeDAOImpl edaoImpl;
	
	
	// Before every test method is run, do this:
	@Before
	public void setup() {
		
		edaoImpl = mock(EmployeeDAOImpl.class); // Reflection at work!
		
		// set the edao of the Employee Service class = to the mocked dao
		EmployeeService.edao = edaoImpl; // I changed the visibility of edao in EmployeeService
	}
	
	// Happy Path Scenario test
	@Test
	public void test_Employee_findByUserName() {
		
		Employee sampleEmp = new Employee(1, "a", "b", "c", "d");
		Employee sampleEmp2 = new Employee(2, "e", "f", "g", "h");
	
		List<Employee> list = new ArrayList<Employee>();
		list.add(sampleEmp);
		list.add(sampleEmp2);
		
		// We program our dao to return that data as its fake DB data
		when(edaoImpl.findAll()).thenReturn(list);
		
		String dummyusername = sampleEmp.getUsername();
		
		// findByUsername() method in the service class returns the fetched user!
		Employee returned = EmployeeService.findByUsername(dummyusername);
		
		assertEquals(sampleEmp, returned);
		
	}
	
	/*
	 * Here we are testing to make sure that our findByUsername() Service 
	 * method retuns null if emp doesn't exist in "db" which is mocked by mockito.
	 */
	@Test
	public void employeeNotPresentInDb() {
		
		List<Employee> emptyList = new ArrayList<Employee>();
		
		when(edaoImpl.findAll()).thenReturn(emptyList);
		
		Employee empFoundByUsername = EmployeeService.findByUsername("test");
		
		// in our logic we said that the findByUsername should return NULL if the Emp doesn't exist
		assertNull(empFoundByUsername);
	}
}












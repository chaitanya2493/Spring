package com.howtodoinjava.demo.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


import com.howtodoinjava.demo.controller.EmployeeController;
import com.howtodoinjava.demo.dao.EmployeeDAO;
import com.howtodoinjava.demo.model.EmployeeVO;
import com.howtodoinjava.demo.service.EmployeeManagerImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	private static final Logger logger = Logger.getLogger(EmployeeControllerTest.class);
	
	@InjectMocks
	EmployeeManagerImpl employeeManager;   

	@Mock
	private EmployeeDAO employeeDAO;
	
	@Before
	public void setup() {
		List<EmployeeVO> employees = new ArrayList<EmployeeVO>();

		EmployeeVO vo1 = new EmployeeVO();
		vo1.setId(1);
		vo1.setFirstName("Ranjan");
		vo1.setLastName("Gupta");
		employees.add(vo1);

		EmployeeVO vo2 = new EmployeeVO();
		vo2.setId(2);
		vo2.setFirstName("Shekar");
		vo2.setLastName("Kishore");
		employees.add(vo2);
		
		employeeDAO = Mockito.mock(EmployeeDAO.class);
		Mockito.when(employeeDAO.getAllEmployees()).thenReturn(employees);
	}

	@Test
	public void testGetAllEmployees() {
		
		List<EmployeeVO> sampleouts =  employeeManager.getAllEmployees();
		logger.debug(sampleouts.size() );
		for (EmployeeVO sampleout: sampleouts) 
		{
		  logger.debug(sampleout.getFirstName());
		}
	}

}

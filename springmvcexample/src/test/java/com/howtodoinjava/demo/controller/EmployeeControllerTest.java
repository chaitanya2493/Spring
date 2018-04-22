package com.howtodoinjava.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.howtodoinjava.demo.controller.EmployeeController;
import com.howtodoinjava.demo.model.EmployeeVO;
import com.howtodoinjava.demo.service.EmployeeManager;
import com.howtodoinjava.demo.service.EmployeeManagerImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	private static final Logger logger = Logger.getLogger(EmployeeControllerTest.class);
	

    @Mock
	private EmployeeManager managerService;
    
    @InjectMocks
    private EmployeeController employeeController;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
 
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        
        this.mockMvc.perform(get("/employee-module/getAllEmployees")
                .param("id", "1234567890"));
                //.andExpect(is("12334567890"));     
    }
    
    @Test
    public void testGetEmployees() throws Exception {

        this.mockMvc.perform(get("/employee-module/getExpectedValues/{id}", "123"))
		.andExpect(status().isOk());     
    }

}

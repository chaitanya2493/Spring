package com.howtodoinjava.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.howtodoinjava.demo.service.EmployeeManager;

@Controller
@RequestMapping("/employee-module")
public class EmployeeController 
{
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeManager manager;

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public String getAllEmployees(Model model)
	{
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
		
		//logs exception
		logger.error("This is Error message", new Exception("Testing"));
		
		model.addAttribute("employees", manager.getAllEmployees());
		return "employeesListDisplay";
	}
}
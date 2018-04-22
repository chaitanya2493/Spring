package com.howtodoinjava.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.howtodoinjava.demo.service.EmployeeManager;

@Controller
@RequestMapping("/employee-module")
public class EmployeeController {
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeManager manager;

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public String getAllEmployees(Model model)
	{
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
		
		
		model.addAttribute("employees", manager.getAllEmployees());
		return "employeesListDisplay";
	}
	@RequestMapping(value = "/getExpectedValues/{id}", method = RequestMethod.GET)
	public String getExpectedValues(@PathVariable("id") String sid, Model model)
	{
		if(logger.isDebugEnabled()){
			logger.debug("Id value: " + sid);
		}
		System.out.println("value id:"+ sid);
		model.addAttribute("id", sid);
		return null;
		
	}
}
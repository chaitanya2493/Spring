package com.howtodoinjava.demo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.*;

public class CallServiceTest {

	CallService callService;
	
	@Before
	public void setup() {
		ICalculator cal = mock(ICalculator.class);
		when(cal.add(3,3)).thenReturn(6);
		callService = new CallService();
		callService.setCal(cal);
	}
	
	@Test
	public void testAddTwoNumbers() {
		Assert.assertEquals(6, callService.addTwoNumbers(3, 3));
	}

}

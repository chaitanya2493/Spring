package com.howtodoinjava.demo.service;

public class CallService {
	ICalculator cal;

	public ICalculator getCal() {
		return cal;
	}

	public void setCal(ICalculator cal) {
		this.cal = cal;
	}

	public int addTwoNumbers(int x, int y) {
		return cal.add(x, y);
	}

}

package com.day3.OOPs.Abstraction;

public class TestInherited extends Test {

	private int num2;

	public TestInherited(int num, int num2) {
		super(num);
		this.num2 = num2;
	}

	// inherited abstracted class must implement abstract methods
	@Override
	void multiply(int digit) {
		int result = getNum() * digit;
		setNum(result);
	}
	
}

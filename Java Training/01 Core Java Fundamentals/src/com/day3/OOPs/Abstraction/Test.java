package com.day3.OOPs.Abstraction;

public abstract class Test {

	private int num;

	public Test(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	// we just give the method header/signature but no body is given
	abstract void multiply(int digit);
	
	
	//we have given implementation - concrete methods
	public void display() {
		System.out.println("value of num : " + num);
	}
}

package com.moulik.basic;


public class VarArgsDemo {

	public static void main(String[] args) {
		
		CalculatorAdd cal = new CalculatorAdd();
		System.out.println(cal.add(3,2,2,21,4));
	
	}

}

class CalculatorAdd {
	
	public int add(Integer... varArray) {
		int sum = 0;
		for(int m: varArray) {
			sum = sum + m;
		}
		return sum;
	}
}
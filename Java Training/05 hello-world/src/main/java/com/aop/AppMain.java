package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			CalculatorService calc = context.getBean(CalculatorService.class);

			// cal add method
			System.out.println("Sum 4 + 4");
			int sum = calc.add(4, 4);
			System.out.println("Result of sum is : " + sum);

			// cal divide 10,2
			System.out.println("divide 10 by 2");
			int res = calc.divide(10, 2);
			System.out.println("result of divide is : " + res);
			
			System.out.println("divide 10 by 0");
			try {
				int d= calc.divide(10, 0);
			}catch(ArithmeticException e) {
				System.out.println("Cannot perform division by 0");
			}
		}
	}
}

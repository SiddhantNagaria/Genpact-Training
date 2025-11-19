package com.day5.Relations_And_FP.Streams_and_FI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class OrderApp {
	public static void main(String[] args) {		
		// Order List
		List<Order> orders = Arrays.asList(
				new Order("Ord001", 2000),
				new Order("Ord002", 8000),
				new Order("Ord003", 12000),
				new Order("Ord004", 4500)
				);
		//print all orders using method reference - refer to printOrder()
		orders.forEach(Order::printOrder); // instance method reference		
		// filter out orders whose amount > 5000
		// two new orders - 005 and 006		
		List<String> highValueOrders = 
			  orders.stream()
		      .filter(Order :: isHighValue) // static method reference
		      .map(o -> o.id.toUpperCase())
		      .collect(Collectors.toList());
		
        System.out.println(highValueOrders);        
        orders.stream()
	      .filter(Order :: isHighValue)
	      .forEach(System.out :: println);
        
//		List<Order> orders = 
//		orders.stream()
//		.filter(Order::isHighValue)
//		.map(order -> order::printOrder);

        
       // filter high order values
       // convert id to Upper Case
       // collect them in list
        
       // stream        ------- -> filter the order ------
       //        ord1   -------                     ------ Ord2 and Ord3
		// Ord2, Ord3 -> map - apply opertaion to all -> ORD2, ORD3
		// ==========> ORD2, ORD3 -> [ORD2, ORD3]
	}

}

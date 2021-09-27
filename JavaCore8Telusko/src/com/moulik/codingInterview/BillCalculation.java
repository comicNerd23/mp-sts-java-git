package com.moulik.codingInterview;

import java.util.Scanner;

/**
 * Problem Statement – Vohra went to a movie with his friends in a Wave theatre
 * and during break time he bought pizzas, puffs and cool drinks. Consider the
 * following prices :
 * 
 * Rs.100/pizza Rs.20/puffs Rs.10/cooldrink 
 * Generate a bill for What Vohra has bought.
 * 
 * Sample Input 1:
 * 
 * Enter the no of pizzas bought:10 Enter the no of puffs bought:12 Enter the no
 * of cool drinks bought:5 Sample Output 1:
 * 
 * Bill Details No of pizzas:10
 * 
 * No of puffs:12
 * 
 * No of cooldrinks:5
 * 
 * Total price=1290
 * 
 * ENJOY THE SHOW!!!
 *
 */
public class BillCalculation {

	public static final int PIZZA_PRICE = 100;
	public static final int PUFF_PRICE = 20;
	public static final int COLD_DRINK_PRICE = 10;
	
	
	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter the no of pizzas bought:");
			int noOfPizzas = sc.nextInt();
			System.out.println("Enter the no of puffs bought:");
			int noOfPuffs = sc.nextInt();
			System.out.println("Enter the no of cool drinks bought:");
			int noOfCoolDrinks = sc.nextInt();
			
			System.out.println("Bill Details");
			System.out.println("No of pizzas:"+noOfPizzas);
			System.out.println("No of puffs:"+noOfPuffs);
			System.out.println("No of coolDrinks:"+noOfCoolDrinks);
			
			int totalPrice = noOfPizzas*PIZZA_PRICE + noOfPuffs*PUFF_PRICE + noOfCoolDrinks*COLD_DRINK_PRICE;
			System.out.println("Total Price="+totalPrice);
			System.out.println("ENJOY THE SHOW!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

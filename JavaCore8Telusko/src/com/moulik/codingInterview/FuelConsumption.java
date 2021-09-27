package com.moulik.codingInterview;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Write a program to calculate the fuel consumption of your truck. The program should ask the user to enter the quantity of diesel to fill up the tank and the 
 * distance covered till the tank goes dry. Calculate the fuel consumption and display it in the format (liters per 100 kilometers).
 * Convert the same result to the U.S. style of miles per gallon and display the result. If the quantity or distance is zero or negative display 
 * ” is an Invalid Input”.
 * [Note: The US approach of fuel consumption calculation (distance / fuel) is the inverse of the European approach (fuel / distance ). 
 * Also note that 1 kilometer is 0.6214 miles, and 1 liter is 0.2642 gallons.]
 * The result should be with two decimal place.To get two decimal place refer the below-mentioned print statement :
 * float cost=670.23;
 * System.out.printf(“You need a sum of Rs.%.2f to cover the trip”,cost);
 */
public class FuelConsumption {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the no of liters to fill the tank");

			int volumeInLiters = sc.nextInt();
			if (volumeInLiters <= 0) {
				System.out.println(volumeInLiters + " is an Invalid Input");
			} else {
				System.out.println("Enter the distance covered");
				int distanceInKm = sc.nextInt();
				if (distanceInKm <= 0) {
					System.out.println(distanceInKm + " is an Invalid Input");
				} else {
					double fuelConsEurope = (double) volumeInLiters / (double) distanceInKm * 100;
					System.out.println("Liters/100KM");
					System.out.println(new Formatter().format("%.2f", fuelConsEurope));
					double miles = (double) distanceInKm * 0.6214;
					double gallons = (double) volumeInLiters * 0.2642;

					double fuelConsUS = (double) miles / (double) gallons;
					System.out.println("Miles/gallons");
					System.out.println(new Formatter().format("%.2f", fuelConsUS));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

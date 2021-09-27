package com.moulik.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ‘CompletableFuture’ provides a method called 'thenCombine' which can be used to perform some actions after two independent Futures are completed. It accepts 
 * 	as argument a 'CompletableFuture' instance and a 'BiFunction' instance and applies the 'BiFunction' to the results of the ‘CompletableFuture’, on which it’s
 *  invoked and passed as an argument. The following code demonstrates this:
 *
 */
public class ThreadDemo12CombiningResults {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<Double> lengthOfRectangle = CompletableFuture.supplyAsync(() -> 5.6);

		CompletableFuture<Double> widthOfRectangle = CompletableFuture.supplyAsync(() -> 2.4);

		System.out.println("Calculating the area of the Rectangle:");

		CompletableFuture<Double> combinedFuture = widthOfRectangle.thenCombine(lengthOfRectangle, (length, width) -> length*width);

		System.out.println("Area is "+combinedFuture.get());
		
	}

}

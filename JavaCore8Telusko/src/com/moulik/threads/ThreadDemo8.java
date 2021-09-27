package com.moulik.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * The ‘supplyAsync’ method is similar to the ‘runAsync’ method and can be used to spawn a new Thread and run code at the same time, with the only 
 * difference being that it can be used to return a value from the Thread. Accepting a ‘Supplier’ instance as a parameter, this works to supply the
 * return value and returns a ‘CompletableFuture<T>’ that corresponds to the return value which is produced by the ‘Supplier’ instance. The following
 * code demonstrates this method:
 */
public class ThreadDemo8 {

	public static void main(String[] args) {
		
		try {
			Supplier<String> supplier = () -> "hello";

			System.out.println("Starting new Thread from main");

			CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(supplier);

			System.out.println("Main Doing something else");

			System.out.println("Blocking and retrieving result in Main");

			String result1 = cFuture1.get();

			System.out.println("Result is " + result1);

			System.out.println("Main thread completed");
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}

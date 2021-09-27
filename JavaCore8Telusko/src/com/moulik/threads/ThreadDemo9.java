package com.moulik.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * The ‘runAsync’ and ‘supplyAsync’ methods demonstrated above get a Thread from the ‘ForkJoinPool.commonPool’ (which is a global Thread pool). It’s key to 
 * remember that there are overloaded versions of these methods that accept an ‘Executor’ instance and obtain Threads from the passed executor.
 *
 */
public class ThreadDemo9 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Runnable runnable = () -> System.out.println("Threading saying Hello");

		System.out.println("Starting new Thread from Main");

		CompletableFuture<Void> cFuture = CompletableFuture.runAsync(runnable, Executors.newSingleThreadExecutor());

		System.out.println("Main Doing something else");

		System.out.println("Main completed");

		System.out.println("------------------------------------------");
		
		Supplier<String> supplier = () -> "Hello";
		
		System.out.println("Starting new Thread from main");
		
		CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(supplier, Executors.newSingleThreadExecutor());
		
		System.out.println("Main Doing something else");

		System.out.println("Blocking and retrieving result in Main");

		String result1;

		result1 = cFuture1.get();

		System.out.println("Result is " + result1);

		System.out.println("Main thread completed");
		
		
		
	}

}

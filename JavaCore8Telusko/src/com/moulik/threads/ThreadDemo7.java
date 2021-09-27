package com.moulik.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * Common Disadvantages of Future
 * Although the ‘Future’ interface enables you to return a result from a Thread, it has several disadvantages including:
 * 
 * 1. The 'get' method in the 'Future' interface is blocking, so if the result of computation is complete, it returns immediately. Otherwise, it'll wait till the
 * computation is completed.  If you want to perform some actions on the result of the computation, you'll need to wait till the result is available.
 * 2. There's no way to manually complete the task. So if the task is hung, there is no way of manually marking it as complete.
 * 3. Multiple 'Futures' cannot be chained or combined.
 * 4. The 'Future' interface does not support any exception handling mechanism.
 * 
 * To solve all these issues, the ‘CompletableFuture’ class was introduced by Java 8.
 *
 * CompletableFuture
 *	The ‘CompletableFuture’ class implements the ‘Future’ interface. In addition, it also implements the ‘CompletionStage’ interface and has several features 
 *	that help to overcome any shortcomings from the ‘Future’ interface
 */
public class ThreadDemo7 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//The most basic way to create 'CompletableFuture'
		CompletableFuture<String> result = new CompletableFuture<String>();

		//If you’re sure about the result of a ‘CompletableFuture’, you can also make it as follows:
		CompletableFuture<String> completableFuture1 = CompletableFuture.completedFuture("Hello");
		
		/*
		 * Note that creating a ‘CompletableFuture’ like the example above isn’t very useful because it doesn’t spawn a new Thread.
		 * 
		 * Just like the ‘Future’ class, ‘CompletableFuture’ has a method called ‘get’ which can be used to obtain the result of computation. The ‘get’ method 
		 * blocks just like ‘Future.get()’. 
		 * 
		 * As an example, if you create a ‘CompletableFuture’ like so:
		 * CompletableFuture<String> result = new CompletableFuture<String>();
		 * 
		 * and invoke ‘result.get’, the above example will block forever because there is no thread to complete and therefore no result to return. Ultimately,
		 * the ‘CompletableFuture.get’ method should only be used to obtain the result when code runs asynchronously as explained below.
		 * 
		 * CompletableFuture has two static methods: runAsync and supplyAsync
		 */
		
		/*
		 * The ‘runAsync’ method can be used to spawn a new thread and run code asynchronously, whilst accepting a ‘Runnable’ instance as a parameter. It doesn’t
		 * return any result and so instead returns a ‘CompletableFuture<Void>’. Overall, this method should be used when the thread doesn't return any value, 
		 * with the following code demonstrating how this works
		 */
		Runnable runnable = () -> System.out.println("Threading saying Hello");

		System.out.println("Starting new Thread from Main");

		CompletableFuture<Void> cFuture = CompletableFuture.runAsync(runnable);

		System.out.println("Main Doing something else");

		System.out.println("Main completed");
		
		
	}

}

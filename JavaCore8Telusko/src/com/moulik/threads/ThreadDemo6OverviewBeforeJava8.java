package com.moulik.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The Runnable interface: Java offers the ‘Runnable’ interface to support multi-threading. This interface provides the run method which executes code
 * in a separate thread. The downside of using ‘Runnable’? The main thread has no way of knowing that the run method has completed, meaning it can’t be used
 * to return a result to the main method. (main thread will know other thread is done only when it will finish and hence again there is delay)
 * 
 * Callable and Future: 
 * 	From Java 5 onwards In order to overcome this issue in the ‘Runnable’ interface, Java 5 introduced the ‘Callable’ interface.
 * 	‘Callable’ is similar to ‘Runnable’ and can be used to spawn a new thread, as well as return the result of a computation. In addition to the ‘Callable’
 * 	interface, Java 5 also added the ‘Executor’ framework and the ‘Future’ interface. What’s more, ‘Callable’ can be used with the ‘Executor’ framework
 * 	to return the result of a computation via a ‘Future’ instance. A ‘Future’ is nothing but a result of an asynchronous computation that’ll be available
 * 	sometime in the future. The following code demonstrates how this works:
 */
public class ThreadDemo6OverviewBeforeJava8 {

	public static void main(String[] args) {

		try {
			
			/*
			 * Callable is similar to Runnable in many aspects but Callable can return a value while Runnable cannot.
			 * Also call() method can return a CheckedException but run() cannot.
			 */
			Callable<String> callable = () -> {
				System.out.println("Entered Callable");
				Thread.sleep(1000);
				return "Hello";
			};

			System.out.println("Starting new Thread");

			ExecutorService executorService = Executors.newSingleThreadExecutor();

			Future<String> future = executorService.submit(callable);
			
			System.out.println("Doing something else");
			
			System.out.println("Retrieve thread result");

			String result;
			result = future.get(); // this blocks till result is available
			System.out.println("Result is:" + result);
			executorService.shutdown();
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
	}

}

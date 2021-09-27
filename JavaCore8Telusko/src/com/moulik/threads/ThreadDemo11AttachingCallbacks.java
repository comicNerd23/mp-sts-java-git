package com.moulik.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * As we discussed previously, one of the disadvantages to the 'Future.get' method is that it blocks until the result of computation is available. If you want to
 * perform some actions on the result in the main thread, you’ll need to wait for the result to be available. The ‘CompletableFuture’ overcomes this limitation
 * by providing the ability to attach callback methods. These callback methods execute once the result of the computation is available, so you’ll no longer need
 * to wait for the result. The examples below are callback methods supported by ‘CompletableFuture’:
 *
 */
public class ThreadDemo11AttachingCallbacks {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("-----------------------------------------------thenAccept--------------------------------------------------");
		
		Supplier<String> supplier = () -> "World!";
		//CompletableFuture.thenAccept(Consumer)
		CompletableFuture.supplyAsync(supplier).thenAccept((str) -> System.out.println("Hello "+str));
		
		System.out.println("-------------------------------------------------thenApply------------------------------------------------");
		
		Supplier<String> supplier2 = () -> "Hello";
		//CompletableFuture.thenApply(Function)
		CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(supplier2).thenApply(str -> str.toUpperCase());

		String result = cFuture.get();

		System.out.println("Result:"+result);

		System.out.println("---------------------------------------------Chaining CallBacks----------------------------------------------------");
		
		//The real power of callbacks is that they can be chained together to perform a series of operations, like so:
		CompletableFuture.supplyAsync(supplier2).thenApply(str -> str.toUpperCase()).thenAccept(str -> System.out.println(str));
		
		
		System.out.println("--------------------------------------Async Methods-----------------------------------------------------------");
		/*  Most of the callback methods have an 'async' version which has the “async” text appended to the method name. The 'async' version of the method helps to
		 *	further parallelise the operations by executing the callback task in a separate thread. The following code demonstrates the 'thenAcceptAsync' method:
		 *	In this particular case, the lambda expression provided to the 'thenAcceptAsync' method will be executed in a separate thread.
		 */

		CompletableFuture.supplyAsync(supplier).thenAcceptAsync((str) -> System.out.println("Hello "+str));
		
	}

}

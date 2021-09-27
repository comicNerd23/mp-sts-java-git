package com.moulik.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * allOf
 * ‘CompletableFuture’ provides a static method called 'allOf' which can be used to perform some actions after several Futures are completed.
 * 
 * anyOf
 * The 'anyOf' method is also a static method on the ‘CompletableFuture’ class and returns a ‘CompletableFuture’ that gets completed when any of the futures with
 * which it is invoked is completed
 */
public class ThreadDemo13CombiningMultipleFeatures {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("---------------------------------allOf------------------------------------------");
		
		CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(() -> "This");
		CompletableFuture<String> cFuture2 = CompletableFuture.supplyAsync(() -> "is a ");
		CompletableFuture<String> cFuture3 = CompletableFuture.supplyAsync(() -> "Java");
		CompletableFuture<String> cFuture4 = CompletableFuture.supplyAsync(() -> "Program");

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(cFuture1, cFuture2, cFuture3, cFuture4);
		combinedFuture.get();
		
		System.out.println("---------------------------------anyOf------------------------------------------");

		//CompletableFuture<String> cFuture1 = CompletableFuture.supplyAsync(() -> "This");
		//CompletableFuture<String> cFuture2 = CompletableFuture.supplyAsync(() -> "is a ");
		//CompletableFuture<String> cFuture3 = CompletableFuture.supplyAsync(() -> "Java");
		//CompletableFuture<String> cFuture4 = CompletableFuture.supplyAsync(() -> "Program");

		CompletableFuture<Object> anyofFuture = CompletableFuture.anyOf(cFuture1, cFuture2, cFuture3, cFuture4);

		System.out.println("Waiting for any of the futures to complete");

		String result = (String)anyofFuture.get();

		System.out.println("Result:"+result);
		
	}

}

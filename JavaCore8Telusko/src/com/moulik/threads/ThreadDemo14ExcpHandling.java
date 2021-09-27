package com.moulik.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * ‘CompletableFuture’ provides a method called 'exceptionally' for exception handling. If an error occurs, the code within the 'exceptionally' method gets 
 *  executed. The following code demonstrates this:
 */
public class ThreadDemo14ExcpHandling {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		String name = null;

		CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(() -> {

			if (name != null) {

				return "Hello " + name;

			} else {

				throw new RuntimeException("Null Input");

			}

		}).exceptionally(ex -> {

			System.out.println("Wrong input: " + ex.getMessage());

			return "Unknown!";

		});

		System.out.println("Result : " + cFuture.get());

	}

}

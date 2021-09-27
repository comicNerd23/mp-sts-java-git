package com.moulik.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * Here we’ll be exploring some of its features and how it can help to overcome the shortcomings of the Future interface.
 * 
 * 1. Manually completing a task
 * As we mentioned earlier, one of the disadvantages of the Future interface is that there’s no way to manually complete a task. Thankfully, ‘CompleteableFuture’
 * provides a method called ‘complete’ which can be used to complete a task.
 *
 */
public class ThreadDemo10ManualCompletion {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Supplier<String> supplier = () -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "hello";
		};

		System.out.println("Starting new Thread");

		CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(supplier);

		System.out.println("Doing something else");

		System.out.println("Waiting for Thread to complete..");

		int count = 0;
		while (!cFuture.isDone()) {

			Thread.sleep(500);

			System.out.println("Still waiting");

			count++;

			if (count == 4)

				break;

		}

		System.out.println("Waited enough, completing manually");

		cFuture.complete("Hello2");

		String result = cFuture.get();

		System.out.println("Result is " + result);

		System.out.println("Main thread completed");

	}
}

package com.moulik.threads.dheeru;

/**
 * ExecutorService interface
 * 	extends Executor interface
 * 	provides methods for submitting tasks and managing termination
 * 
 * ExecutorService.submit() is a better task submission method compared to execute()
 * 	ExecutorService execService = Executors.newFixedThreadPool(10);
 * 
 * Future future = exexService.submit(task); //Here task can be Runnable or Callable (better task representation for 
 * scenarios when execution a task to completion can take some time and we would also need result of the computation)
 * Future.get() blocks until task is completed. If the task is Callable, it returns result. If Runnable, then returns 
 * null.
 * 	
 * 	public interface Callable<V> {
 * 		V call() throws Exception;
 * 	}
 * 
 * ExecutorService Lifecycle
 * It has 3 states: RUNNING, SHUTTING_DOWN and TERMINATED
 * Initially the executorService will be in RUNNING state and in this state, it will accept tasks and execute them.
 * When we call shutdown() or shutdownNow(), it will move into SHUTTING_DOWN state. No new tasks will be accepted.
 * RejectedExecutionException will be thrown if a new task is submitted now.
 * When the shutdown() or shutdown() completes execution, it will move into TERMINATED state.
 * shutdown() ~ submitted tasks (active + queued) will be executed. No new tasks are accepted.
 * shutdownNow() ~ interrupts active tasks + ignores queued tasks
 * isTerminated() ~ tells if the executorService is terminated. 
 * 
 * Why care about terminated state?
 * 	monitoring: In a large scale application, we might have to reuse the same executor and at some point, we might want
 * 	to shutdown where it will not accept any new tasks. But if the tasks are taking too long to execute, we might want
 * 	to expedite the process.
 * 
 * 		execService.shutdown();
 * 		if (!exexService.awaitTermination(60, TimeUnit.SECONDS)) {
 * 			executor.shutdownNow();
 * 			if (!exexService.awaitTermination(60, TimeUnit.SECONDS)) {
 * 				System.err.println("Could not terminate!!");
 * 			}
 * 		}
 * 
 * Future ~ represents lifecycle of a task, aka it can be used to track the progress of a submitted task.
 * 	
 * 	public interface Future<V> {
 * 		boolean cancel(boolean mayInterruptIfRunning);
 * 		boolean isCancelled();
 * 		boolean isDone();
 * 		V get() throws InterruptedException, ExecutionException;
 * 		V get(long timeout, Timeunit unit) throws InterruptedException, ExecutionException, TimeoutException;
 * 	}
 * 
 * TimeoutException is thrown, when the thread could not be completed in a specified time.
 * InterruptedException is thrown, when the thread was interrupted.
 * ExecutionException is thrown when the underlying task threw some Exception. The actual cause of the exception can be 
 * inspected by calling the Throwable.getCause().
 * Both get() methods can thrown an unchecked exception called CancelledException if the task was cancelled.
 * 
 * Summary:
 * 	1. Get Executor
 * 		ExecutorService executor = Executors.newFixedThreadPool(10);
 * 	2. Submit Task
 * 		Future future = executor.submit(task);
 * 	3. Fetch Result
 * 		future.get()
 * 	4. Shutdown Executor
 * 		executor.shutdown()
 * 
 *
 */
public class ExecutorServiceAndFutureDemo15 {

	public static void main(String[] args) {

	}

}

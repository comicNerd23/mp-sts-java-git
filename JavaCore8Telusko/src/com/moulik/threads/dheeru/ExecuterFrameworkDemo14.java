package com.moulik.threads.dheeru;

/**
 * Till now, we have seen a Thread-per-task approach. For every new task, we had a new thread.
 * This approach is feasible only for small-scale applications. In large scale apps, it will have limitations like 
 * Thread creation and teardown costs, Resource Consumption (esp memory), instability (boundless thread creation).
 * Solution: Prefer executors and tasks to threads.
 * 
 * Execution Framework is a flexible and powerful task execution framework. It consists of a work queue and a thread 
 * pool.
 * 
 * How it fixes thread-per-task limitations:
 * 		Thread creation and teardown costs 			----- 		employs ready-to-use threads
 * 		Resource Consumption (esp memory) 			-----		fixed pool size
 * 		Instability (boundless thread creation) 	-----		fixed pool size
 * 
 * 	public interface Executor {
 * 
 * 		void execute(Runnable command);
 * 	}
 * 
 * Thread-per-task Executor 
 * 	public class ThreadPerTaskExecutor implements Executor {
 * 		void execute(Runnable r) {
 * 			new Thread(r).start();
 * 		}
 * 	}	
 * 	Executor executor = new ThreadPerTaskExecutor();
 * 	executor.execute(someRunnable);
 * 	executor.execute(someOtherRunnable);
 * 
 * Single Threaded Executor
 * 	public class SingleThreadedExecutor implements Executor {
 * 		public void execute(Runnable r) {
 * 			r.run();
 * 		}
 * 	}
 * 
 * With this kind of framework, we are able to decouple task submission from task execution.
 * 
 * java.util.concurrent.Executors
 * 
 * 	newFixedThreadPool(int n)	: returns ExecutorService with a thread pool of a fixed size of max n threads.	
 * 	newCachedThreadPool()		: returns ExecutorService with a thread pool of a fixed size
 * 	newSingleThreadedExecutor	: returns ExecutorService
 * 	newScheduledThreadPool		: returns ScheduledExecutorService
 * 
 * newFixedThreadPool(int n)
 * 	1. Fixed-size thread pool, size = n threads
 * 	2. Creates upto n threads as tasks are submitted
 * 	3. When pool size is reached, either reuse idle threads or task is queued
 * 	4. New thread is added if a thread dies due to Exception
 * 	5. Good for heavily loaded production servers
 * 	6. Reconfigure pool size by : ( (ThreadPoolExecutor) fixedPool).setMaximumPoolSize(10)
 * 	7. newSingleThreadedExecutor() ~  newFixedThreadPool(1). No reconfiguring of pool size possible
 * 
 * newCachedThreadPool
 * 	1. Tasks are not queued (like thread-per-task)
 * 	2. New Task will either reuse idle thread or create new thread. In newFixedThreadPool, new task will reuse thread 
 *  only when the pool size is reached.
 * 	3. Max idle time for a thread is 60 seconds. After that, it will be terminated. In newFixedThreadPool, there is no 
 * 	such restriction on idle time of thread.
 * 	4. Good for lightly loaded production servers
 * 
 * newScheduledThreadPool(int corePoolSize)
 * 	1. Fixed-size thread pool for delayed and periodic task execution. eg You can configure a task to run after 60 
 *  seconds or you can configure a task to run every 15 seconds.
 *
 *
 */
public class ExecuterFrameworkDemo14 {

	public static void main(String[] args) {

	}

}

package com.moulik.threads.dheeru;

import java.util.concurrent.TimeUnit;

/**
 * Volatile Variables help ensure memory visibility. 
 * They are stored in main memory (not registers or cache)
 * Used with shared mutable variables.
 * 
 * Performance-wise volatile is faster than using synchronized blocks but synchronized provides both memory visibility
 * and mutual exclusion. With volatile variables, mutual exclusion is not guaranteed.
 * 
 * When a variable is declared as volatile, program runs fine when one thread writes and others read operation and there is
 * no race condition. When there is a race condition, we should use synchronized block.
 * 
 * More on memory semantics:
 * Actions preceding a write to a volatile field or release of a lock are visible to all actions that follow a "subsequent"
 * read of same volatile variable or acquisition of same lock. 
 * 
 * x is a regular variable while v is a volatile variable
 * 	Time Instance				Thread A								Thread B
 * 		T1						x = 10, v= 15
 * 		T2																Launched
 * 		T3						x = 11								
 * 		T4														Reads x. Sees x = 10 (stale)
 * 		T5						v = 16 (write)
 * 		T6														Reads v then x. Sees v = 16 and x = 11
 *
 */
public class VolatileVariableDemo6 {

	private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
    	 new Thread(new Runnable() {
              public void run() {
                   while(!stop) { System.out.println("In while ..."); }
              }
          }).start();

          TimeUnit.SECONDS.sleep(1);
          stop = true; 
    }

}

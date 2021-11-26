package com.moulik.threads.dheeru;

/**
 * A race condition is an undesirable situation that occurs when a device or system attempts to perform two or more 
 * operations at the same time, but because of the nature of the device or system, the operations must be done in the 
 * proper sequence to be done correctly.
 * Race conditions are most commonly associated with computer science and programming. They occur when two computer 
 * program processes, or threads, attempt to access the same resource at the same time and cause problems in the system.
 * 
 * Consider a BankAccountExample in which two members John and Anita have a joint account with a balance of 100$. 
 * BankAccount class has a balance variable and makeWithdrawal().
 * 
 * Assume John and Anita want to withdraw 75$ at the same time. So, program creates two threads for John and Anita.
 * John's thread enters into RUNNING and enters makeWithdrawal(), checks balance>=amount and at this point, TS (thread 
 * scheduler) moves the program into RUNNABLE state. Next Anita's thread comes to RUNNING state, enters makeWithdrawal(), 
 * checks balance>=amount and deducts the amount. Balance now is 25$. Now since Anita's thread is fully executed, TS
 * brings John's thread back to RUNNING state and assuming the balance is still 100$ withdraws the amount. But the amount
 * now is overdrawn, that is 25-75 = -50$. So the system is now in a bad state.
 * 
 * This happened because BankAccount object was not made thread-safe, that is bank account had a mutable state. But this
 * mutable object was being shared by multiple threads. The process of changing states was not properly managed. This
 * not properly managed is actually called Race Condition (of type check-then-act). Another type of race condition is 
 * 'read-modify-write' (when two processes read a value in a program and write back a new value.)
 * The solution to this is to make makeWithdrawal() an atomic unit, that once a thread enters this method, it should be 
 * allowed to finish before any other thread can work on it. This behavior is also called Mutual Exclusion. 
 * 
 * Non-thread-safe object -> incorrect program -> data corruption
 * 
 * Actually non-thread object are because of mutable shared state. If there was no state (no instance variable), then
 * there would be no issues.
 * 
 * Consider another program which has Race Condition issue. The IdGenerator class simply generates a new Id by 
 * incrementing the current id. However, getNewId() performs the operation in 3 steps. 
 * Consider that current value of id is 3. Two threads call getNewId(). Lets assume that after doing the read and 
 * increment by Thread A, TS suspends Thread A and brings Thread B into RUNNING state. Now since Thread A's incremented
 * value of 4 was not written to id, Thread B reads the id value as 3, increments it and writes it back to 4. Thread B
 * is done, so TS bring Thread A to RUNNING state. Since its value was 4 it updates it again to 4. Now, the system is 
 * again in bad state because, 2 updates should happen on the getNewId() method and id should be of value 5 now. 
 * Instead, the value is still 4. 
 * 
 *	class IdGenerator {
 *	
 *		private long id;
 *
 *		long getNewId() {
 *			return id++;  //read id,	increment id, 	write id
 *		}
 *	}
 * 
 */
public class RaceConditionDemo3 {

	public static void main(String[] args) {
		
		BankAccount task = new BankAccount();
		   task.setBalance(100);
		   
		   Thread john = new Thread(task);
		   Thread anita = new Thread(task);	   
		   john.setName("John");
		   anita.setName("Anita");
		   john.start();
		   anita.start();	

	}

}
class BankAccount implements Runnable {
	private int balance;
	public void setBalance(int balance) {
		this.balance = balance;		
	}
	
	public void run() {
		makeWithdrawal(75);
		if (balance < 0) {
			System.out.println("Money overdrawn!!!");
		}
	}	

	private void makeWithdrawal(int amount) { //Add synchronized here to make it thread-safe
	
		if (balance >= amount) {
			System.out.println(Thread.currentThread().getName() + " is about to withdraw ...");
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + " bucks");
	    } else {
	    	System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
	    }
	}
	
}


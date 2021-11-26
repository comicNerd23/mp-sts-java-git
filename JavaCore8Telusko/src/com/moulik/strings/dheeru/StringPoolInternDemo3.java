package com.moulik.strings.dheeru;

/**
 * String Literals vs new String()
 * 		String via literals	are:
 * 			stored in String pool on heap
 * 			literals with same content share storage
 * 		String via new
 * 			same as Regular Objects
 * 			No storage sharing
 * 
 * Consider the heap memory of JVM which will have a small part inside of it called String pool
 * String s1 = "hello";				//Creates a new allocation "hello" in String pool and s1 references it
 * String s2 = "hello";				//Since "hello" already present in String pool, s2 references to the same "hello"
 * String s3 = s1;					//Since "hello" already present in String pool, s3 references to the same "hello"
 * String s4 = new String("hello"); //In heap memory, Creates a new allocation "hello" and s4 references it
 * 									//In string pool, already has "hello", so heap-memory object just references it
 * String s5 = new String("hello"); //In heap memory, Creates another new allocation "hello" even though it already has
 * 									//it and S5 references this new "hello"
 * 									//In String pool, similar to s4
 * 
 * So, s1 == s2 true	s2 == s3 true		s1 == s3 true
 * But s1 == s4 false	s1 == s5 false		s4 == s5 false
 * 
 * Summary: String Pool stores single copy of each string literal as string object. There is only one String pool.
 * String Pool is also called as String table.
 * 
 * String Interning:
 * The process of building string pool is also called String Interning. Each string element in the pool is called 'Intern'.
 * This process is also supported in other languages such as Python, Ruby, JavaScript, C#.
 * 
 * When JVM encounters a string literal for the first time, it does 2 things:
 * 1. Creates new String object with given literal in the heap
 * 2. invokes intern()
 * 		if (string is present in string pool)
 * 			return existing reference	//the String object created in step 1 is abandoned and will be garbage collected
 * 		else
 * 			add to string pool and return reference
 * 
 * 	String s = "hel" + "lo"; 	//The resulting s will also be 'interned' as it is known at compile-time
 * 	String s1 = "lo";
 * 	String s2 = "hel" + s1;		//The resulting s2 will not be 'interned' as it is known only at run-time
 * 	s2 = s2.intern();			//Here we can call intern() explicitly
 * 
 * Is Explicitly Interning useful?
 * It is most likely not useful for us in an application. It is useful when called by JVM internally.
 * But in certain scenarios like in Natural Language Processing, where there could be numerous strings being created, 
 * it might be more efficient to call intern() but that would need to be performance-benchmarked before taking a decision.
 * 
 * 
 */
public class StringPoolInternDemo3 {

	static void stringPool() {
		System.out.println("\nInside stringPool ...");
		String s1 = "hello!";
		String s2 = "hello!";
		String s3 = "hello!".intern();
		String s4 = new String("hello!");
		String s5 = "lo!";
		final String s6 = "lo!";
		String s7 = new String("hello!");

		System.out.println("s1 == s2: " + (s1 == s2));
		System.out.println("s1 == s3: " + (s1 == s3));
		System.out.println("s1 == s4: " + (s1 == s4));
		System.out.println("s1 == s4.intern(): " + (s1 == s4.intern()));
		System.out.println("s1 == \"hel\" + \"lo!\": " + (s1 == "hel" + "lo!"));
		System.out.println("s1 == \"hel\" + s5: " + (s1 == "hel" + s5));
		System.out.println("s1 == \"hel\" + s6: " + (s1 == "hel" + s6));
		
		System.out.println("s4 == s7: " + (s4 == s7));
	}

	public static void main(String[] args) {
		// Language Basics 1
		  //print();				
		  //primitives();
		  //typeCasting();
		  //arrays();	
	      //threeDimensionalArrays();	
	      /*varargsOverload(true, 1, 2, 3);
	      varargsOverload(true, 1, 2, 3, 4, 5, 6, 7, 8);	  
	      varargsOverload(true);*/
		  //charTypePromotion();
		  //bitwiseOperators();
		  //switchExample();
		  //labeledBreak();
		  //labeledContinue();
	      // import demo
	      // package creation demo
	      //stringExamples();	
	      stringPool();
	}

}

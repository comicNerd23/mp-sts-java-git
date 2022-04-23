package com.moulik.exception;

/**
 * Error and Exception extends Throwable
 * RuntimeException extends Exception
 * 
 * “Error” is a critical condition that cannot be handled by the code of the program.
 * 
 * 	
 * OutOfMemoryError:
 * OutOfMemoryError is a runtime error in Java which occurs when the Java Virtual Machine (JVM) is unable to allocate an 
 * object due to insufficient space in the Java heap. The Java Garbage Collector (GC) cannot free up the space required 
 * for a new object, which causes a java.
 *	
 * The JVM's memory management scheme sets aside a portion of the heap memory to store newly allocated objects. Any 
 * referenced objects remain active in the heap throughout their lifespan (until their reference is closed) and occupy 
 * memory. When objects are no longer referenced, they become eligible for the GC to remove them and free up the occupied
 * heap memory.
 * 
 * The Java heap size is determined by two JVM attributes, which can be set when launching Java:
 * 	-Xms to set the initial heap size
 * 	-Xmx to set the maximum heap size
 * 
 * 
 * AssertionError:
 * The meaning of an AssertionError is that something happened that the developer thought was impossible to happen.
 * So if an AssertionError is ever thrown, it is a clear sign of a programming error.
 * See the AssertionDemoExample class below. In that class, we want to forbid the empty initialization of a class. So, we
 * set the constructor as private. Hence, this class can never be instantiated and an object of this class will never
 * exist. However, if such an object came to exist somehow in our application, an AssertionError can be set to throw.
 * 
 * StackOverflowError:
 * Parameters and local variables are allocated on the stack (with reference types, the object lives on the heap and a 
 * variable in the stack references that object on the heap). The stack typically lives at the upper end of your address 
 * space and as it is used up it heads towards the bottom of the address space (i.e. towards zero).
 * Your process also has a heap, which lives at the bottom end of your process. As you allocate memory, this heap can grow
 * towards the upper end of your address space. As you can see, there is a potential for the heap to "collide" with the 
 * stack (a bit like tectonic plates!!!).
 * The common cause for a stack overflow is a bad recursive call. Typically, this is caused when your recursive functions
 * doesn't have the correct termination condition, so it ends up calling itself forever. Or when the termination condition
 * is fine, it can be caused by requiring too many recursive calls before fulfilling it.
 *
 *
 */
public class ErrorDemo {

    public static void main(String[] args) {
    	OutOfMemoryErrorExample outOfMemoryErrorExample = new OutOfMemoryErrorExample();
    	outOfMemoryErrorExample.createArray(1000 * 1000 * 1000 * 100);
    	
    	//StackOverflowErrorExample.recursivePrint(1);
    	
    	//AssertionDemoExample x = new AssertionDemoExample();
    }

}
class OutOfMemoryErrorExample {
	public void createArray(int size) {
        try {
        	//Here is an example of a java.lang.OutOfMemoryError thrown due to insufficient Java heap space:
            Integer[] myArray = new Integer[size];
            System.out.println("MyArray created of size:"+myArray.length);
        } catch (OutOfMemoryError oome) {
            //Log the info
        	System.out.println("Array size too large");
            System.err.println("Array size too large");
            System.err.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
        }
    }
}
class StackOverflowErrorExample {

    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);
        if (num == 0)
            return;
        else
            recursivePrint(++num);
        }

}
class AssertionDemoExample {
    private AssertionDemoExample() {
        throw new AssertionError();
    }
}
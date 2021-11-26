package com.moulik.jvm;

/**
 *  Stack is another area on the JVM Runtime memory.
 *  We know that lifetime of a type is used to create a Class object.
 *  The Class object along with other object are created on the Heap.
 *  The class data that is meta-info is stored on Method Area.
 *  
 *  To execute each method including static methods, JVM must keep track of some info such as currently executing methods,
 *  other methods invoked by this the currently executing method and so on. This is stored on Stack. This is the info for
 *  methods that are currently being executed, not the ones that have finished execution or the ones that have yet not been
 *  invoked.
 *  
 *  LIFO Data Structure
 *  One Stack Per Thread
 *  	When a method is invoked, an entity called Stack Frame containing method info is pushed onto the stack. Now if this
 *  method invokes another method, a new Stack Frame containing that method infor will be created and pushed onto the 
 *  stack. The Stack Frame pops off the stack when the method completes execution, either normally or abruptly through
 *  some error. 
 *  The info that is stored on the stack frame is local variables and for objects, only object references are stored in
 *  the stack frame. The actual object is stored on the heap. When this stack frame is popped off, the obj ref is lost
 *  and the obj on the heap is considered abandoned.
 *  
 *  Stack Frame Contents
 *  1. Local Variables array (LVA)
 *  2. Operand Stack
 *  3. Reference to the Runtime	Constant Pool of the class of the current method.
 *  
 *  Local Variables array stores the method parameters and local variables. For static methods, the 0th element is the 
 *  'this' reference. For regular methods, the 0th element is the method parameter and followed by subsequent method
 *  parameters and local variables. Array will also include the return address (memory address of the next instruction
 *  in the calling method). If the method runs successfully without any errors, then the PC is updated with this return
 *  address. JVM's execution engine will then execute the instruction at that memory address.
 *  
 *   Operand Stack (OpS)
 *   Similar to General-purpose Registers in CPU
 *   Central focus of JVM's instruction set (as values are generally pushed onto it before they are used)
 *   Stores values received by invoked methods
 *   
 *   Operand Stack Example
 *   
 *   Method instructions				Byte-Code instructions
 *   int y = 1;							iconst_1			creating const value 1 and pushed it on OpS
 *   int z = 3;							istore_1			pops the const value 1 and storing it in 1st index in LVA
 *   int x = y + z;						iconst_3			creating const value 3 and pushed it on OpS
 *   									istore_2			pops the const value 3 and storing it in 2nd index in LVA
 *   														At this point, Ops is empty, LVA has 1, 3
 *   									iload_1				Loads the value from index 1 of LVA to Ops
 *   									iload_2				Loads the value from index 2 of LVA to Ops
 *   									iadd				Pops two int value from top of Ops and adds them and pushes 
 *   														the result back to the Ops
 *   									istore_3			pops the int value 3 from Ops and stores it in 3rd index in LVA
 *   
 *
 */
public class StackAndStackFrame15 {

}

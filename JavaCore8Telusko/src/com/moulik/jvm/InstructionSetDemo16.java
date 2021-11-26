package com.moulik.jvm;

/**
 * 
 * INSTRUCTION SET
 * 
 * Similar to CPU having an instruction set, JVM also has an instrunction set. For JVM, it is Method's bytecode stream.
 * 
 * Bytecode instruction -> 1 Byte opcode + operands
 * 
 * Opcode specifies the operation to be performed and operands are the values on which operation is supposed to be 
 * performed.
 * e.g iadd, iload_1: iadd - add two operands, iload_1 - load (push) the index 1 of LVA onto OpS
 * 
 * Like CPU, JVM's execution engine also follows fetch-and-execute lifecycle. That is, it fetches the opcode and 
 * corresponding operands and executes the opcode on the operands. 
 *
 *	javap is the java bytecode disassembler library that comes pre-built with jdk.
 *	
 *		javap -c Hello.class 	will show the method bytecode
 *		javap -v Hello.class 	will show the method bytecode and constant pool
 *
 *	aload_0: 'a' represents object, load index 0 from LVA onto OpS
 *
 *	invokespecial #1: operand is #1, invokes constructor in the super class (Object class in this program)
 *					it is invoked for instance initialization (constructor) methods, private methods and superclass methods
 *					via super keyword.
 *					#1 is an offset into the runtime constant pool of the current class. Check #1 in constant pool
 *
 * Constant Pool
 * Simply put, a constant pool contains the constants that are needed to run the code of a specific class. Basically, 
 * it's a runtime data structure similar to the symbol table. It is a per-class or per-interface runtime representation 
 * in a Java class file.
 * 
 * It is something like this below: (Here not all parts of Constant Pool are shown. Constant Pool is contiguous)
 * 		
 * 		#1 = Methodref			#9.#20				// java/lang/Object."<init>":()V
 * 		#9 = Class				#28					// java/lang/Object
 * 		#28 = Utf8				java/lang/Object
 * 		#20 = NameAndType		#10.#11				// "<init>":()V
 * 		#10 = Utf8				<init>
 * 		#11 = Utf8				()V										<- Method Descriptor (parameters and return type V)
 * 
 * invokespecial
 * 		Method Resolution (init: replacing symbolic reference with direct reference)
 * 		Create stack frame for the method on stack
 * 		Pop stack element and store it at index 0 in local variables array
 * 		Set PC to first instruction in method
 * 
 * invokevirtual
 * 	Check inheritence chapter. 
 * 	Method Signature binding happens at compile-time. But method implementation binding happens at run-time
 * 		
 * 		Method Resolution (in our case it is resolution of toString() in the method class) -> index # in method table
 * 		Method Implementation lookup
 * 			objRef -> object on heap -> method table[index]
 *		Create stack frame for the method on stack
 *		Pop stack element and store at index 0 in LVA
 *		Set PC to first instruction in method 
 *
 *	getstatic #5 		- get and push static field value onto the operand stack
 *	ldc #6 		 		- load (push) constant at index 6 onto OpS
 *	invokevirtual #7 	- pop "Hello" and out reference. Invoke println
 *	areturn				- returning an object reference
 *
 * invokestatic
 * 	covered in method binding and used for invoking static methods
 * 
 * invokeinterface
 * 	when a class implements an interface. Try it out by Hello implement an interface.
 *
 * Below is the JVM specification page that lists all the Java bytecode instructions 
 *	https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html
 */
public class InstructionSetDemo16 {

	int i = 3;
    public static void main(String[] args) {
        Object hello = new InstructionSetDemo16(); 	//change to Hello() and change the file and class name to hello before
        											//running javap from command-line
        hello.toString();
    }

    public String toString() {    
	    System.out.println("Hello"); 
		return "hello";
    }

}

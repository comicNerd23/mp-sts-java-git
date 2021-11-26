package com.moulik.jvm;

/**
 * Knowledge of Runtime Data Areas in JVM is very important for handling Performance Tuning and other memory related issues
 * like OutOfMemoryError.
 * 
 * Process Virtual Address Space
 * Whenever any program runs on an OS, it gets a chunk of memory from its underlying OS. This memory is called Native 
 * memory. The program will also have its own Virtual Address Space which maps to a physical file or any file or any
 * addressable storage. This Virtual Address Space will have two parts: User space and Kernel Space. Kernel space is 
 * where the Kernel (core of that program) executes and provides its services. This kernel space is shared by all the
 * programs. However, the UserSpace is unique to each process and that is the native memory too.
 * 32-bit Windows gives 2 GB kernel space and 2 GB user space. On 32-bit Linux, it 1 GB kernel space and 3 GB user space.
 * 
 * Runtime Areas in JVM
 * 
 * [Native Heap]		[Method Area]	[Java Heap]		[{	[JVM Stack]		[PC]	[Native Method Stack]	} per Thread]
 * 
 * Native Heap is actually (total JVM user space - Java Heap). It consists of several areas like JIT Code, Direct Buffer.
 * It can hold code that is compiled by JIT Compiler. Recall that JIT Compiler converts frequently used bytecode to 
 * machine code. It stores that here on the native heap for faster performance. DirectBuffer is useful to store some
 * data to be cached.
 * 
 * Java Heap is used to store Java Objects (including Class objects and arrays).
 * 
 * Method Area is used to store class data (like meta-information of the class like fully qualified class name, superclass
 * name and so on.) It also includes bytecode of each method.
 * 
 * Each object will have its own share of Java Heap area and Method area (to store its class information). Multiple 
 * objects of the same class will have same Method area. 
 * Now both Method area and heap are shared among all the threads. That is, each thread shares some part from method area
 * and heap. But Thread has some things specific to it like JVM Stack, PC(Program Counter) and Native Method Stack.
 * 
 * JVM Stack stores info such as Method Invocation state (like order of invocation of methods) and local variable info.
 * 
 * Native Method Stack stores info similar to JVM Stack but for native methods (usually used internally).
 * 
 * Program Counter (PC) holds the memory address of the next instruction. That is, it holds a pointer to the method area,
 * because Method area is where we have method bytecode.
 * 
 * 
 *
 */
public class RuntimeDataAreas8 {

}

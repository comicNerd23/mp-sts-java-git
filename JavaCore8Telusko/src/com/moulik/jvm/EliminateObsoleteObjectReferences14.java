package com.moulik.jvm;

/**
 * Despite the efforts of GC, there can still be memory leaks in the app. To avoid this, we need to eliminate obsolete
 * object references as per Effective Java Item 66.
 * 
 * class Stack<T> {
	
		public void push(Object e) {
			ensureCapacity();
			elements[size++] = e;
		}
	
		public T pop() {
			if(elements.size() == 0) {
				throw new EmptyException();
			}
		
			return elements[--size];				//Memory leak
		}
	}
 * 
 * Here we have a memory leak because the popped-off object that is being returned form the method will still be present
 * at that previous memory location in the array.
 * 
 * Memory Leak -> Increased memory footprint -> Increased GC Activity -> Performance degradation
 * 
 * Solution is to null out object references.
 * 
 * class ImprovedStack<T> {
	
		...
	
		public T pop() {
			if(elements.size() == 0) {
				throw new EmptyException();
			}
			
			Object object = elements[--size];
			elements[size] = null;
			return object;
		}
	}
 *
 * When to null out references?
 *	Be careful in these cases where we ourselves are handling the operations that can manipulate object memory.
 *	No need to null out everywhere.
 *
 * Generally, such memory leaks are detected by performance monitoring tools.
 * 
 * 
 * 
 * Following are different ways of using garbage collectors. 
 * java -XX:+UseSerialGC ClassName 
 * 		Serial GC for both young & old generations
 * java -XX:+UseParallelGC -XX:+UseParallelOldGC ClassName 
 * 		Parallel GC for both young & old generations
 * java -XX:+UseParNewGC -XX:+UseConcMarkSweepGC ClassName 
 * 		Parallel New for Young + Concurrent Mark and Sweep (CMS) for Old Generation
 * java -XX:+UseG1GC ClassName
 * 		G1 in case of which the generations are not separated between Young and Old
 * 
 * You can also checkout the following resource to learn more about garbage collection. It is a great resource on GC. 
 * They have a commercial product on monitoring Java programs and so they pretty much deal with performance related 
 * aspects like GC on a daily basis.
 * 
 * https://plumbr.eu/handbook/garbage-collection-algorithms-implementations
 * 
 * 
 * 
 * Summary:
 * 		identify and reclaim abandoned objects
 * 				Mark and Sweep Algorithms
 * 
 * 		Reduce application pause times
 * 				Generational Collections
 */
public class EliminateObsoleteObjectReferences14 {

}

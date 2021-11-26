package com.moulik.jvm;

/**
 * Generational Collection is a technique which employs some of the core Gc Algorithms and helps reduce the application
 * pause time while Gc does its task.
 * Usually an application will have some objects that stay alive for long and some objects that die very soon. If there is
 * a way to distinguish such objects, JVM can run GC on short-living objects more frequently than on the long-living object
 * thereby reducing the application pause time.
 * 
 * This is made possible by two different memory areas in the heap called the Young Generation and Old Generation.
 * Young Generation is supposed to hold short-living objects and Old Generation, long living objects.
 * Young Generation has further 3 separations of space called Eden, Survivor-from and Survivor-to.
 * 
 * ** Young-to-old process **
 * 
 * Full GC(Generational Collection) = Young GC + Old GC + PermGem/Metaspace
 * 
 * Old typically uses Mark-Sweep-Compact or Just Mark-Sweep algorithm
 * 
 * So, GC is used to reduce application pause time. Pause times are further reduced by making use of multithreading. While
 * the app is paused, GC is run quickly using multiple threads.
 * 
 * Garbage Collector Types:
 * 												Young 							Old
 * 		Serial GC(Single-threaded)			Mark and Copy				Mark-Sweep-Compact
 * 		Parallel GC(Multi-threaded)			Mark and Copy				Mark-Sweep-Compact
 * 		CMS(Multi-threaded)					Mark and Copy				Concurrent Mark-Sweep
 * 
 * Mark-and-Copy requires the application to pause.
 * CMS(Concurrent Mark-Sweep) can run mostly concurrently with the application but also requires pauses.
 * 
 * New GC called G1 (Garbage First).
 * 			Parallel and Concurrent; Less Heap Memory; Reduce Old GC time
 * 
 * By default, GC used by JVM is dependent on the platform. But if there is any specific GC class that you need to use, 
 * then you can pass its name as an option to the java interpreter.
 * 		java --XX:+UseConcMarkSweepGC Classname (Asking JVM to use CMS as GC)
 */
public class GcGenerationalCollections12 {

}

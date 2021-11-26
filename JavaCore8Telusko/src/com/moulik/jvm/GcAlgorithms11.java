package com.moulik.jvm;

/**
 * GC Challenges:
 * How do you identify Abandoned objects?
 * How do you reduce application pause times?
 * 
 * Algorithms for Identify and Reclaim Dead Objects
 * Mark and Sweep: 
 * 	In Mark phase, GC identifies all the live objects (reachable objects in a graph at a specific point in 
 * time). In Sweep phase, a sweep over the entire heap area is performed to keep track the heap areas that are not marked
 * as live. 
 * In such algorithm, it is necessary to pause the application because otherwise, there can be new objects that might not
 * be marked and hence keep the space occupied.
 * 
 * Mark-sweep-compact:
 * Mark and sweep phases are similar as above but compact phase is used to relocate the used memory area so as to avoid
 * fragmentation issues. This will help allocating large java objects. Disadvantage: increase in pause time.
 * 
 * Mark and Copy:
 * Mark phase is same as above but In copy phase, the allocated objects which might have fragmentation are copied into a
 * new memory region. Advantage is that there will be less pause time because mark phase and copy can be done at the same
 * time, ie, when objects are being marked, at the same time, the objects can be copied.
 * 
 *
 */
public class GcAlgorithms11 {

}

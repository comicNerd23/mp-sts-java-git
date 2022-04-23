package com.moulik.java8;

import java.util.List;

/**
 * CollectionApiImprovements:
 * 1. Iterator default method forEachRemaining(Consumer action) to perform the given action for each remaining element 
 * until all elements have been processed or the action throws an exception.
 * 2. Collection default method removeIf(Predicate filter) to remove all of the elements of this collection that satisfy 
 * the given predicate
 * 3. Collection spliterator() method returning Spliterator instance that can be used to traverse elements sequentially 
 * or parallel.
 * 4. Map replaceAll(), compute(), merge() methods.
 * 5. Performance Improvement for HashMap class with Key Collisions
 * 
 * ConcurrencyApiImprovements
 * 1. ConcurrentHashMap compute(), forEach(), forEachEntry(), forEachKey(), forEachValue(), merge(), reduce() and search()
 * methods.
 * 2. CompletableFuture that may be explicitly completed (setting its value and status).
 * 3. Executors newWorkStealingPool() method to create a work-stealing thread pool using all available processors as its 
 * target parallelism level.
 *
 */
public class CollectionApiImprovements {
	
	List<Integer> rollNos = List.of(101,102,103,104,105);

}

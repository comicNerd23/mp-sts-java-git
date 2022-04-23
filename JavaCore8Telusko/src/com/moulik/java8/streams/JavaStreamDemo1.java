package com.moulik.java8.streams;

/**
 * Before we look into Java Stream API Examples, let’s see why it was required. Suppose we want to iterate over a list of
 * integers and find out sum of all the integers greater than 10.
 * 
 * private static int sumIterator(List<Integer> list) {
 * 	Iterator<Integer> it = list.iterator();
 * 	int sum = 0;
 *	while (it.hasNext()) {
 *		int num = it.next();
 *		if (num > 10) {
 *			sum += num;
 *		}
 *	}
 *	return sum;
 * }
 *
 * There are three major problems with the above approach:
 * 1. We just want to know the sum of integers but we would also have to provide how the iteration will take place, this 
 * is also called external iteration because client program is handling the algorithm to iterate over the list.
 * 2. The program is sequential in nature, there is no way we can do this in parallel easily.
 * 3. There is a lot of code to do even a simple task.
 * 
 * To overcome all the above shortcomings, Java 8 Stream API was introduced. We can use Java Stream API to implement 
 * internal iteration, that is better because java framework is in control of the iteration.
 * Internal iteration provides several features such as sequential and parallel execution, filtering based on the given 
 * criteria, mapping etc
 * 
 * Collections and Java Stream:
 * 1. A collection is an "in-memory" data structure to hold values and before we start using collection, all the values 
 * should have been populated. Whereas a java Stream is a data structure that is computed "on-demand".
 * 2. Java Stream doesn’t store data, it operates on the source data structure (collection and array) and produce 
 * pipelined data that we can use and perform specific operations. Such as we can create a stream from the list and filter 
 * it based on a condition.
 * 3. Java Stream operations use functional interfaces, that makes it a very good fit for functional programming using 
 * lambda expression. As you can see in the above example that using lambda expressions make our code readable and short.
 * 4. Java 8 Stream internal iteration principle helps in achieving lazy-seeking in some of the stream operations. For 
 * example filtering, mapping, or duplicate removal can be implemented lazily, allowing higher performance and scope for 
 * optimization.
 * 5. Java Streams are consumable, so there is no way to create a reference to stream for future usage. Since the data is 
 * on-demand, it’s not possible to reuse the same stream multiple times.
 * 
 * 
 * Java Stream Intermediate and Terminal Operations
 * Java Stream API operations that returns a new Stream are called intermediate operations. Most of the times, these 
 * operations are lazy in nature, so they start producing new stream elements and send it to the next operation. 
 * Intermediate operations are never the final result producing operations. Commonly used intermediate operations are 
 * filter and map.
 * Java 8 Stream API operations that returns a result or produce a side effect are terminal operations. Once the terminal 
 * method is called on a stream, it consumes the stream and after that we can’t use stream. Terminal operations are eager 
 * in nature i.e they process all the elements in the stream before returning the result. Commonly used terminal methods 
 * are forEach, toArray, min, max, findFirst, anyMatch, allMatch etc. You can identify terminal methods from the return 
 * type, they will never return a Stream.
 * 
 * Java Stream Short Circuiting Operations
 * An intermediate operation is called short circuiting, if it may produce finite stream for an infinite stream. For 
 * example limit() and skip() are two short circuiting intermediate operations.
 * A terminal operation is called short circuiting, if it may terminate in finite time for infinite stream. For example 
 * anyMatch, allMatch, noneMatch, findFirst and findAny are short circuiting terminal operations.
 * 
 */
public class JavaStreamDemo1 {

}

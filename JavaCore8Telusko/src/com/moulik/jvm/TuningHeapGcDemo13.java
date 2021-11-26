package com.moulik.jvm;

/**
 * Options to set 
 * 
 * -Xms13m  			Min amount of memory allocated to the Heap(m = MB, g = GB, k = KB)
 * -Xmx13m  			Max amount of memory allocated to the Heap
 * -XX:+PrintGCDetails	Print GC details whenever it happens
 * -XX:+UseSerialGC		Use Serial GC
 * 
 * -XX:+MaxNewSize:1m	Restricts max amount of memory for young generation to 1 MB	(This option is rarely used in RW apps)	
 *
 */
public class TuningHeapGcDemo13 {
	
	static int[] iArray = new int[2*1024*1024]; //(8.4 MB approx) 1 integer takes 4 bytes
	
	public static void main(String[] args) {
		
	}

}

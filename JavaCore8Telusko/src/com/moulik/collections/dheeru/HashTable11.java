package com.moulik.collections.dheeru;

/**
 * Hashtable is a widely used fundamental data structure because it supports some really fast operations like searching
 * of elements. It is used to implement an associative array between keys and values.
 * E.g <name, phone>. Each key-value pair is also referred to as mapping and Hashtable is referred to as Dictionary.
 * 
 * Key Operations: O(1)
 * 1. Insert <key, Value>
 * 2. Search By Key
 * 3. Remove By Key
 * 
 * Hashtable Characteristics
 * 1. No duplicate keys
 * 2. Duplicate values is fine
 * 3. 1 key can have atmost 1 value
 * 4. Nulls:
 * 		Some implementations allow 1 null key, multiple null values (HashMap, LinkedHashMap)
 * 		Some implementations allow no null keys and values. (TreeMap)
 * 
 * Implementation:
 * 
 * 	Buckets				Entries
 * 	000	X				
 * 	001	O				O	Lisa Smith	521-8976
 * 	002 X
 * 	
 * 	151 X
 * 	152 O		->		O	John Smith	521-1234		->	X	Sandra Dee 521-9655 
 * 	153 O		->		X	Ted Baker	521-4165
 * 	154 X
 * 	
 * 	253 X
 * 	254	O		->		X 	Sam Doe		521-5030
 *  255 X
 *  
 *  Here, HT is an associative-array, hence each element is referencing a linked list. Each mapping is stored based on 
 *  a Hash Function in corresponding buckets. Similarly, when we want to search an element quickly, we need to find the
 *  bucket using hash function.
 *  
 *  	bucket # = f(key, array-size)
 *  	e.g key % array-size
 *  Transforms large space into small space.
 *  		15	= 315 % 25 
 *  
 *  Generally, Hashing involves 2-Step. In Java also we have 2-Step Hashing.
 *  
 *  	hash = hash(key.hashCode())				hash(h)
 *  												h ^= (h >>> 20) ^ (h >>> 12);
 *  	bucket # = hash & (length-1)				return h ^ (h >>> 7) ^ (h >>> 4);
 *
 * HashFunction Properties
 * 	1. Quickly locate bucket: HashFunction should be highly efficient. E.g Using multiple multiplication and division can
 *  be slow, but using bitwise and bitshift operations such as the hash(h) will give us performance benefit.
 * 	2. Uniformly disperse elements: Hash function should be able to disperse the elements as uniformly as possible into
 *  buckets. E.g if we use only the hashcode of key, instead of this additional hash(h), then there is a chance that
 *  several keys may get hashed into the same bucket. This is called Hash Collision. This can make the search slow
 *  since once we find the bucket, we might need to perform a linear search on the corresponding linked list to find the
 *  target mapping. Ideally, there should be one mapping per bucket. But that is highly unlikely and so we should try
 *  to minimize the mapping as much as possible.
 *  
 *  Insertion (using Separate chaining ~ collision resolution technique)
 *  After finding the bucket (using 2-Step Hashing), if it is empty:	Add new LL with mapping
 *  If not empty, i.e. there is some mapping present:
 *  	if mapping with key exists: Override value
 *  	if mapping with key does not exist: add mapping in front
 * 
 * Other performance factors
 * 	Capacity = Number of buckets
 * 	load factor = decides when to resize
 * For Hashset, default capacity is 16 and load factor is 0.75
 * In a hashtable, resizing involves expensive rehashing.
 * When you choose a high load factor, it might cause less frequency of re-hashing but there may be more collisions and
 * hence more lookup time. 
 * Recommendation: Generally, use defaults and if very large number of operations then do some experimentations to choose
 * the right values. 
 * 
 * Applications of hashtables:
 * 1. Database Indexing
 * 2. NoSql Databases
 * 3. Switch statement
 * 
 * 	
 */
public class HashTable11 {

}

package com.moulik.collections.dheeru;

import java.util.HashSet;
import java.util.Set;

/**
 * Set is a collection of elements which models a mathematical "Set", ie, no duplicates. It is useful when uniqueness
 * and fast-lookup matters.
 * HashSet is based on hashtable for fast-lookups and it internally uses HashMap.
 * SortedSet provides Sorting (in addition to uniqueness and fast-lookups).
 * 
 * Unlike List, Set interface does not provide any new methods other than those inherited from the Collection interface. 
 * However, due to the fact that it does not allow duplicates, it just places additional requirements on some of the 
 * inherited methods and constructors. E.g. addAll() explicitly states duplicates are not allowed.
 * 
 * HashSet
 * 1. It is an hashtable implementation of Set interface. 
 * 2. Internally it uses a hashmap which uses key-value pairs. Key = element, value = new Object(). 
 * (Check source code for add() in HashSet)
 * 3. It permits one null element
 * 
 * Typical Uses of HashSet
 * 1. Rapid lookup, insertion and deletion O(1)
 * 2. Insertion Order is not important
 * 3. Better (than ArrayLists) for frequent removeAll() and retainAll() operations.
 * 
 * Typically, the hashcode() returns the memory address of the corresponding object after converting it into int
 * representation.
 * 
 * When we are adding objects to a Set, it will only allow unique elements. But if we try to do it with user-defined
 * classes like Book, it will add the duplicate elements also. This is because, the set is not able to understand if
 * two objects of Book are equal. For that, we need to override the default equals() and hashCode() method.
 * If we override only the hashcode(), again it will allow duplicates because it will be able to find the correct bucket
 * to store the object. But when it finds the bucket, it will check the mapping. In the mapping, it will compare the 
 * object using the equals() and since equals is not overridden, it will think the two objects are not equals and hence,
 * it will create a new mapping and add it to the bucket instead of replacing the value in the original mapping. 
 * If we override only the equals(), then it might be possible that element is stored in a completely different bucket
 * because the hashcode is different.
 * 
 * 
 * Always Override hashcode() when you override equals()
 * If you want to treat two objects as logically equals, you must override both equals() and hashcode().
 * 
 * Iteration of a HashSet is dependent on sum of HashSet instance's size (number of elements) and capacity of backing
 * HashMap (number of buckets). Thus, it's very important not to set the initial capacity too high (or the load factor
 * too low) if iteration performance is important.
 */
public class SetHashSetDemo12 {

	private static void hashSetDemo() {
		Set<String> set1 = new HashSet<>();
		set1.add("a");
		set1.add("b");
		set1.add("a");
						
		System.out.println("set1: " +  set1);
		
		Book book1 = new Book("Walden", "Henry Thoreau", 1854);
		Book book2 = new Book("Walden", "Henry Thoreau", 1854);
		Set<Book> set2 = new HashSet<>();
		set2.add(book1);
		set2.add(book2);
		System.out.println("set2: " +  set2);
	}
	
	public static void main(String[] args) {
		hashSetDemo();
	}	
	
}

class Book {
	private String title;
	private String author;
	private int year;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Book(String title, String author, int year) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	/*public int hashCode() {
		return title.hashCode();
	}

	public boolean equals(Object o) {
		return (year == (((Book)o).getYear())) && (author.equals((((Book)o).getAuthor())));
	}*/
	
}
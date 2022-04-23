package com.moulik.collections.dheeru;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet
 * 1. It is a red-black tree-based implementation of NavigableSet interface
 * 2. Internally uses TreeMap. Key = element, Value = new Object()
 * 3. Elements are unique and sorted
 * 4. fast lookup too ~ O(log(n)) for add/remove/contains but not as fast as HashSet (O(1))
 * 5. It does NOT allow adding of null element (throws NullPointerExceptionn). However, hashset allows adding 1 null 
 * element.
 * 
 * 
 * TreeSet elements must need to be sorted in a natural order. The objects of such class need to implement Comparable
 * interface, compareTo(Object o). The reason it is called Natural Ordering is because the element themselves are 
 * telling how they need to be sorted.
 * We can also pass another way of sorting/ordering using a Comparator. Here we override the 
 * compare(Object o1, Object o2)
 * 
 * These methods return an integer. If the integer is positive, then the element is greater than previous element and if
 * the integer is negative, then the element is smaller than previous element.
 * 		-1 (least) 0 (equal) 1 (greatest)
 * 
 * 1. If there are multiple elements in TreeSet, then to insert an element into the TreeSet, compareTo() will be 
 * performed for each element and then rightfully placed in the treeset.
 * 2. compare()/compareTo() return int, while equals returns boolean. 
 * 3. If both Comparator and Comparable are present, then Comparator overrides Comparable
 * 4. The advantage of Comparator is that we can pass the ordering at runtime. Such a design pattern is called 
 * Strategy Design pattern where the actual algorithm is being passed at runtime.
 *
 */
public class TreeSetDemo15 {
	
	private static void treeSetDemo() {
		Book1 book1 = new Book1("Harry Potter", "J.K.Rowling", 1997);
		Book1 book2 = new Book1("Harry Potter", "J.K.Rowling", 1997);
		Book1 book3 = new Book1("Walden", "Henry David Thoreau", 1854);
		Book1 book4 = new Book1("Effective Java", "Joshua Bloch", 2008);
			  
		Set<Book1> books = new TreeSet<>(); //Will sort based on natural ordering
		//Set<Book1> books = new TreeSet<>(new TitleComparator()); //Will sort based on comparator ordering
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		//books.add(null); This will give NullPointerException
	      
	    for (Book1 book : books) {
	    	System.out.println(book);
	    }		
	}
	
	public static void main(String[] args) {
		//hashSetDemo();
		//linkedHashSetDemo();
		treeSetDemo();
	}	
	

}
class TitleComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return ((Book1)o1).getTitle().compareTo(((Book1)o2).getTitle());
	}
	
}
class Book1 implements Comparable {
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
	
	public Book1(String title, String author, int year) {
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
		Book1 other = (Book1) obj;
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
	
	public int compareTo(Object book) {
		// return getTitle().compareTo(((Book)book).getTitle()); // utilizing String’s compareTo
		
		//Return the order based on year of publishing
		return Integer.compare(getYear(), ((Book1)book).getYear());
	}
	
}

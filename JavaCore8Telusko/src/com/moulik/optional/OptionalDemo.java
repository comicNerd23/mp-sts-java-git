package com.moulik.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Optional Class is useful for determining when an object is null or when an object can possibly throw 
 * NullPointerException. Java Optional is a container object which may or may not contain a non-null value. If a value is
 * present, isPresent() will return true and get() will return the value. 
 * 
 * Stream terminal operations return Optional object. Some of these methods are:
 * 	Optional<T> reduce(BinaryOperator<T> accumulator)
 * 	Optional<T> min(Comparator<? super T> comparator)
 * 	Optional<T> max(Comparator<? super T> comparator)
 * 	Optional<T> findFirst()
 * 	Optional<T> findAny()
 * 
 * There are 3 methods to create Optional Objects:
 * 	Optional.empty()	Optional.of(T)		Optional.ofNullable(T)
 *
 *	Some Other in-built methods:
 *	1. isPresent(): To check if the optional has an element present and is not null
 *	2. get(): To get the object from the Optional
 *	3. orElse(): In case the optional does not have an element, then do this..
 *	4. orElse(Supplier): In case the optional does not have an element, then run what is there in the supplier
 *	5. orElseThrow(): In case the optional does not have an element, then throw NoSuchElementException
 *	6. orElseThrow(Supplier): In case the optional does not have an element, then throw Exception provided by the supplier
 *	
 */
public class OptionalDemo {

	public static void main(String[] args) {
		
		Optional<Book> emptyBook = Optional.empty();
		System.out.println(emptyBook);
		
		Book hp1 = new Book("HP1",178,"J.K.Rowling");
		Book hp2 = new Book("HP2",178,null);
		Optional<String> x1 = Optional.of(hp1.getAuthor());
		System.out.println("x1:"+x1);
		
		//Optional<String> x2 = Optional.of(hp2.getAuthor()); //Gives null pointer exception
		//System.out.println("x2:"+x2);
		
		Optional<String> x3 = Optional.ofNullable(hp2.getAuthor());
		System.out.println("x3:"+ x3);	//Gives empty instead of null pointer exception
		
		System.out.println("--------------Instance Methods---------------");
		
		try {
			//Here get() will give NoSuchElementException if the optional does not have any value
			System.out.println(x3.get()); 
		} catch(NoSuchElementException e) {
			System.out.println(e.getLocalizedMessage());
		}
		//isPresent() and get()
		if( x3.isPresent() ) {
			System.out.println(x3.get());
		}
		
		//If you want to return some default value when that optional value is not found, use orElse(String) 
		//orElseGet(Supplier) orElseThrow(Supplier)
		System.out.println(x3.orElse("Author not present"));
		
		System.out.println(x3.orElseGet( () -> "Did not find any Author for this.") );
		
		System.out.println(x3.orElseThrow( () -> new IllegalArgumentException("Author not found") ));
		
		
	}

}
class Book {
	
	private String name;
	private Integer pages;
	private String author;
	
	public Book(String name, int pages, String author) {
		super();
		this.name = name;
		this.pages = pages;
		this.author = author;
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<Integer> getPages() {
		return Optional.ofNullable(pages);
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}

package com.moulik.java8;

/**
 * Functional interfaces are a new concept introduced in Java 8. An interface with exactly one abstract method becomes a 
 * Functional Interface. We don’t need to use @FunctionalInterface annotation to mark an interface as a Functional
 * Interface but it is a good practice because it restricts the accidental addition of extra abstract methods.
 * 
 * The major benefit of java 8 functional interfaces is that we can use lambda expressions to instantiate them and avoid 
 * using bulky anonymous class implementation. So lambda expressions are a means to create anonymous classes of functional
 * interfaces easily. There are no runtime benefits of using lambda expressions, so I will use it cautiously because I 
 * don’t mind writing a few extra lines of code.
 * 
 * java.lang.Runnable is a great example of functional interface with single abstract method run()
 *
 */
public class FunctionalInterfacesDemo3 {

	/*
	 * Using Anonymous Classes
	 */
	Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("My Runnable");
        } };
        
    /*
     * Using Lambda Expressions
     */
    Runnable r2 = () -> System.out.println("My Runnable");
     
}
/**
 * Below are some examples of Functional Interfaces
 *
 */
interface Foo { boolean equals(Object obj); }
//Not functional because equals is already an implicit member (Object class)

interface Comparator<T> {
	boolean equals(Object obj);
	int compare(T o1, T o2);
}
//Functional because Comparator has only one abstract non-Object method

interface Foo1 {
	int m();
	Object clone();
}
//Not functional because method Object.clone is not public (but protected)

interface X { int m(Iterable<String> arg); }
interface Y { int m(Iterable<String> arg); }
interface Z extends X, Y {}
//Functional: two methods, but they have the same signature

interface X2 { Iterable m(Iterable<String> arg); }
interface Y2 { Iterable<String> m(Iterable arg); }
interface Z2 extends X2, Y2 {}
//Functional: Y2.m is a subsignature & return-type-substitutable

interface X3 { int m(Iterable<String> arg); }
interface Y3 { int m(Iterable<Integer> arg); }
//interface Z3 extends X3, Y3 {}	//Remove comment for this line to see the compiler error
//Compiler Error, Not functional: No method has a subsignature of all abstract methods

interface X4 { int m(Iterable<String> arg, Class c); }
interface Y4 { int m(Iterable arg, Class<?> c); }
//interface Z4 extends X4, Y4 {}	//Remove comment for this line to see the compiler error
//Compiler Error, Not functional: No method has a subsignature of all abstract methods

interface X5 { long m(); }
interface Y5 { int m(); }
interface Z5 extends X, Y {}
// Compiler error: no method is return type substitutable

interface Foo2<T> { void m(T arg); }
interface Bar2<T> { void m(T arg); }
//interface FooBar2<X, Y> extends Foo2<X>, Bar2<Y> {}	//Remove comment for this line to see the compiler error
// Compiler error: different signatures, same erasure

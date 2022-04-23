package com.moulik.java8;

/**
 * DEFAULT METHODS:
 * Designing interfaces have always been a tough job because if we want to add additional methods in the interfaces, it 
 * will require change in all the implementing classes. As interface grows old, the number of classes implementing it 
 * might grow to an extent that it’s not possible to extend interfaces. That’s why when designing an application, most of
 * the frameworks provide a base implementation class and then we extend it and override methods that are applicable for
 * our application.
 * 
 * Before Java 8, interfaces only allowed to have method declarations, not definitions. Default methods allow us to 
 * provide default implementation in the interfaces which may or may not be overridden in the implementing class. Now when
 * a class will implement an interface, it is not mandatory to provide implementation for default methods of interface. 
 * This feature will help us in extending interfaces with additional methods; all we need is to provide a default 
 * implementation.
 * 
 * Important points regarding Default Methods:
 * 1. Java interface default methods will help us in extending interfaces without having the fear of breaking 
 * implementation classes.
 * 2. Java interface default methods has bridged down the differences between interfaces and abstract classes.
 * 3. Java 8 interface default methods will help us in avoiding utility classes, such as all the Collections class methods
 * can be provided in the interfaces itself.
 * 4. Java interface default methods will help us in removing base implementation classes, we can provide default 
 * implementation and the implementation classes can choose which one to override.
 * 5. One of the major reasons for introducing default methods in interfaces is to enhance the Collections API in Java 8 
 * to support lambda expressions.
 * 6. A default method cannot override a method from java.lang.Object. 
 * One reason is that it would become more difficult to reason about when a default method is invoked. The current rules 
 * are simple: if a class implements a method, that always wins over a default implementation. Since all instances of 
 * interfaces are subclasses of Object, all instances of interfaces have non-default implementations of equals, hashCode,
 * and toString already. Therefore, a default version of these on an interface is always useless, and it may as well not 
 * compile.
 * Another reason is that providing default implementations of these methods in an interface is most likely misguided. 
 * These methods perform computations over the object’s state, but the interface, in general, has no access to state; 
 * only the implementing class has access to this state. Therefore, the class itself should provide the implementations,
 * and default methods are unlikely to be useful.
 * 7. Java interface default methods are also referred to as Defender Methods or Virtual extension methods.
 * 
 * STATIC METHODS:
 * Java interface static method is similar to default method except that we can’t override them in the implementation 
 * classes. This feature helps us in avoiding undesired results in case of poor implementation in implementation classes.
 * 
 * The idea behind static interface methods is to provide a simple mechanism that allows us to increase the degree of 
 * cohesion of a design by putting together related methods in one single place without having to create an object.
 * This makes it easier for you to organize helper methods in your libraries; you can keep static methods specific to an
 * interface in the same interface rather than in a separate class
 * Pretty much the same can be done with abstract classes. The main difference lies in the fact that abstract classes can
 * have constructors, state, and behavior.
 * Furthermore, static methods in interfaces make possible to group related utility methods, without having to create 
 * artificial utility classes that are simply placeholders for static methods.
 * Examples: Predicate.isNull
 * 
 * 1. Java interface static method is part of interface, we can’t use it for implementation class objects.
 * 2. Java interface static methods are good for providing utility methods, eg null check, collection sorting etc
 * 3. Java interface static method helps us in providing security by not allowing implementation classes to override them.
 * 4. We can’t define interface static method for Object class methods, we will get compiler error as “This static method
 * cannot hide the instance method from Object”. This is because it’s not allowed in java, since Object is the base class
 * for all the classes and we can’t have one class level static method and another instance method with same signature.
 * 5. We can use java interface static methods to remove utility classes such as Collections and move all of it’s static
 * methods to the corresponding interface, that would be easy to find and use.
 * 
 *
 */
public class DefaultStaticMethods2 implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	/*
	 * We have to provide our own implementation because this method is present in both Interfaces and hence can lead to 
	 * Diamond Problem for multiple inheritance of interfaces. 
	 */
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
		Interface1.print("abc");
	}

}
interface Interface1 {
	
	private void methodNew() {};
	void method1(String str);
	
	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
	
	static void print(String str){
        System.out.println("Printing "+str);
    }
	
}
interface Interface2 {

	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}
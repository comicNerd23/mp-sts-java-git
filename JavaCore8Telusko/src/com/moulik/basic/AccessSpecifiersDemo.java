package com.moulik.basic;

/**
 * For classes, we can use only public, abstract, final, no other keywords
 * For interfaces, the only keywords allowed are public, abstract
 * 		For fields in an interface, public static final is the only allowed field property. (It is implicit)
 * 		For methods in an interface, public private abstract default static strictfp are permitted
 * 		Only default methods and static methods are allowed with implementations.
 * 		
 * 
 * For classes, the only access specifiers are public and no-access-specifier
 * For a class without any access specifier, default access is given by JVM.
 * A class inside a package has to be public for it to be accessed from outside
 * 
 * Variables can have 4 access levels
 * 1. private: accessible only from the same class (not even the same file, in case a file has two or more classes)
 * 2. default: accessible from the same package
 * 3. protected: accessible from the same package, subclass in other packages
 * 4. public: accessible from anywhere
 */
public class AccessSpecifiersDemo {

	public static void main(String[] args) {

	}

}
interface A {
}

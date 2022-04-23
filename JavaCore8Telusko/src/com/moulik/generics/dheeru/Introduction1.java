package com.moulik.generics.dheeru;

/**
 * Motivation for Generics: Generalization
 * Polymorphism promotes generalization. E.g Superclasses can be used as polymorphic types for method parameters and 
 * constructor parameters and they can also be used as method return types. This allows us to pass subclass objects as 
 * arguments and we can also return subclass objects from methods. Similarly, interfaces provide even more generalization
 * as they can be implemented by classes from completely different class hierarchies.
 * Earlier 'Object' was used as the polymorphic type to provide generalization. But there were some issues with that such
 * as: Two developers casting an object to Date object would run into ClassCastException if one developer used java.sql.
 * Date and other used java.util.Date. 
 * 	Too generic
 * 	Explicit Casting
 * 	RuntimeException
 * 
 * To fix these issues, language designers came up with Generics. Generics is purely compile time concept. 
 * 	Type safety at compile-time. (See Oops chapter for type-safety concept)
 * 	Cleaner code
 * 	Expressive code (Developer explicitly states the type of object)
 * 	Generic (Code can be used with any type)
 * 
 * Agenda:
 * 	Generics Introduction
 * 	Generic Methods
 * 	Invariance		(Very important)
 * 	Wildcards
 * 	Type Erasures
 *  Generics Restrictions
 * 
 *
 */
public class Introduction1 {

}

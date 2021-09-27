package com.moulik.basic;

import java.util.*;

/**
 * To make types easier to find and use, to avoid naming conflicts, and to control access, programmers bundle groups of related types into packages.
 * 
 * A package is a grouping of related types providing access protection and name space management. Note that types refers to classes, interfaces, enumerations, 
 * and annotation types. Enumerations and annotation types are special kinds of classes and interfaces, respectively, so types are often referred to in this
 * lesson simply as classes and interfaces
 * 
 * Package names should start with reverse of your domain name. eg com.google etc
 * When fetching a class, eg java.io.* will fetch all classes from this folder but not the folders found inside it.
 * For that you need to give that explicitly
 * e.g java.util.* will fetch all classes under java.util folder but will not fetch files under the directories under java.util.
 * Like java.util.concurrent.ConcurrentHashMap will not be fetched unless we write java.util.concurrent.*
 */
public class PackagesDemo {

	public static void main(String[] args) {
		
		List<Integer> x = new ArrayList<>();
		//Map<String, Integer> salaries = new ConcurrentHashMap<>(); This will give a compile-time error until we import java.util.concurrent.*
	}

}

package com.moulik.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(101, "Moulik", 550));
		students.add(new Student(241, "Ankit", 560));
		students.add(new Student(55, "Rahul", 450));
		students.add(new Student(123, "Arun", 500));
		
		//This line will change the order of the collection based on natural ordering.
		//This natural ordering has been defined in the compareTo method
		Collections.sort(students);
		//To give our own logic of sorting, we can pass in a Comparator obj
		//Collections.sort(students, (i,j)->(i.marks>j.marks ? 1 : -1));
		students.stream().forEach(s->System.out.println(s));
		
	}

}
class Student implements Comparable<Student> {
	int rollNum;
	String name;
	int marks;
	
	public Student(int rollNum, String name, int marks) {
		this.rollNum = rollNum;
		this.name = name;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", marks=" + marks + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Student o) {
		return rollNum>o.rollNum? 1: -1;	//Ascending order
	}
	
}

package com.moulik.codingInterview;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BarclaysCoding4 {

	public static void main(String[] args) {

		Set<Name> names = new TreeSet<Name>();
		names.add(Name.Alice);
		names.add(Name.Smith);
		names.add(Name.Bob);
		names.add(Name.Smith);
		
		for(Name d : names) {
			System.out.println(d);
		}
		
		List<Employee> employees = List.of(new Employee("MOulik", 29, 123L), 
					new Employee("Manthan", 25, 124L),
					new Employee("Astu", 16, 125L));
		employees.stream()
				.sorted((a,b) -> ( a.getAge()>b.getAge()? 1 : -1 ))
				.map(e -> e.getName())
				.forEach(System.out :: println);
	}

}
enum Name {
	Alice, Smith, Bob, Jones
}
class Employee {
	private String name;
	private Integer age;
	private Long id;
	public Employee(String name, Integer age, Long id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
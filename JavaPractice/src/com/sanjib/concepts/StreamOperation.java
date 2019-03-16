/**
 * 
 */
package com.sanjib.concepts;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author server
 *
 */
public class StreamOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<String> names = Arrays.asList("John", "Andreas", "Michael", "Jessica","Mary");
		
		List<String> longNames = names.stream().filter(n -> n.length()>6).collect(Collectors.toList());
		
		longNames.forEach(System.out::println);
		
		
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student(15, "Rahul", 4));
		students.add(new Student(16, "Rajit", 10));
		students.add(new Student(12, "Anju", 3));
		
		boolean isAnyPresentAboveAge = students.stream().anyMatch(s -> s.getAge() >18);
		System.out.println(isAnyPresentAboveAge);
		
		
		
		names.stream().filter(str -> str.startsWith("A") && str.length()>6).collect(Collectors.toList()).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(1,2,5,9,10,12,15,16,20);
		List<Integer> result = numbers.stream().map(sq -> sq*sq).limit(4).distinct().collect(Collectors.toList());
	    result.forEach(str -> System.out.println(str+" "));
	
	}

}

 class Student
 {
	 private int age;
	 private String name;
	 private int roll;
	 
	public Student(int age, String name, int roll) {
		super();
		this.age = age;
		this.name = name;
		this.roll = roll;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	
	 
	 
 }

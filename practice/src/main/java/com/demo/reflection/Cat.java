package com.demo.reflection;

public class Cat {

	
	private final String name;
	private int age;
	public Cat(String ame, int age) {
		super();
		this.name = ame;
		this.age = age;
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
	
	public void meow() {
		System.out.println("Meow");
	}
	
	private void heyThisIsPrivate() {
		System.out.println("How did you call this??");
	}
	
	public static void thisIsPublicStaticMethod() {
		System.out.println("I'm public and setter");
	}
	
	private static void thisIsPrivateStaticMethod() {
		System.out.println("I'm private");
	}
}

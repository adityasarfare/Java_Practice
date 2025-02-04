package com.demo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CatReflection {

	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Cat myCat = new Cat("Stella", 6);
		
		Field[] fields = myCat.getClass().getDeclaredFields();
		
		for(Field f : fields) {
			if(f.getName().equals("name")) {
				f.setAccessible(true);
			f.set(myCat, "John");
			System.out.println(f.getName());
			}
		}
		
		Method[] methods = myCat.getClass().getDeclaredMethods();
		
		for(Method m : methods) {
			if(m.getName().equals("heyThisIsPrivate")) {
				m.setAccessible(true);
				m.invoke(myCat);
			}
		}
		// For static method
		for(Method m : methods) {
			if(m.getName().equals("thisIsPrivateStaticMethod")) {
				m.setAccessible(true);
				m.invoke(null);
			}
		}
		System.out.println(myCat.getName());
	}
}

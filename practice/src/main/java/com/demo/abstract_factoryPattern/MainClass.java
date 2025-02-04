
package com.demo.abstract_factoryPattern;

public class MainClass {

	
	public static void main(String[] args) {
		AbstractFactory abp = AbstractFactoryProducer.getProfession(true);		
		Profession p = abp.getProfession("engineer");
		p.print();
	}
}

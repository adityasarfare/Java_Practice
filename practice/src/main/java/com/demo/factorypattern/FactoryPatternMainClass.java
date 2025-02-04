package com.demo.factorypattern;

public class FactoryPatternMainClass {

	
	public static void main(String[] args) {
		ProfessionFactory pf = new ProfessionFactory();
		
		Profession p = pf.getProfession("Doctor");
		p.print();
	}
}

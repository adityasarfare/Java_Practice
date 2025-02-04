package com.demo.abstract_factoryPattern;

public class ProfessionAbstractFactory extends AbstractFactory {

	
	public Profession getProfession(String typeOfProfession) {
		if(typeOfProfession == null) {
			return null;
		}
		
		if(typeOfProfession.equalsIgnoreCase("engineer")){
			return new Engineer();
		}
		if(typeOfProfession.equalsIgnoreCase("Teacher")){
			return new Teacher();
		}
		
		
		return null;
	}
}

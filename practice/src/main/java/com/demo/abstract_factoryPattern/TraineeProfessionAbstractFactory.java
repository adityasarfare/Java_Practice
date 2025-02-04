package com.demo.abstract_factoryPattern;

public class TraineeProfessionAbstractFactory extends AbstractFactory {

	
	public Profession getProfession(String typeOfProfession) {
		if(typeOfProfession == null) {
			return null;
		}
		
		if(typeOfProfession.equalsIgnoreCase("engineer")){
			return new TraineeEngineer();
		}
		if(typeOfProfession.equalsIgnoreCase("Teacher")){
			return new TraineeTeacher();
		}
		
		
		return null;
	}
}

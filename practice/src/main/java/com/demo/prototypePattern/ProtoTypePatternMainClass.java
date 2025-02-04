package com.demo.prototypePattern;

public class ProtoTypePatternMainClass {

	
	
	public static void main(String[] args) {
		ProfessionCache.loadProffessionCache();
		
		Profession docProfession = ProfessionCache.getCloneNewProfession(1);
		System.out.println(docProfession);
		
		Profession engProfession = ProfessionCache.getCloneNewProfession(2);
		System.out.println(engProfession);
		
		Profession teachProfession = ProfessionCache.getCloneNewProfession(3);
		System.out.println(teachProfession);
		
		Profession docProfession2 = ProfessionCache.getCloneNewProfession(1);
		System.out.println(docProfession2);
	}
}

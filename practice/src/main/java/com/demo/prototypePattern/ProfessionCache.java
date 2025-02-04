package com.demo.prototypePattern;

import java.util.Hashtable;

public class ProfessionCache {

	
	private static Hashtable<Integer, Profession> professionMap = new Hashtable<Integer, Profession>();
	
	public static Profession getCloneNewProfession(int id) {
		Profession cachedProfessionalInstance = professionMap.get(id);
		try {
			return (Profession) cachedProfessionalInstance.cloningMethod();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cachedProfessionalInstance;
	}
	
	public static void loadProffessionCache() {
		Doctor doc = new Doctor();
		doc.id = 1;
		professionMap.put(doc.id, doc);
		
		Teacher tec = new Teacher();
		tec.id = 2;
		professionMap.put(tec.id, tec);
		
		Engineer eng = new Engineer();
		eng.id = 3;
		professionMap.put(eng.id, eng);
	}
}

package com.demo.Miscellanious;

public class DownCasting {

	
	public static void main(String args[]) {

		Animal a = new CastingExample();

		DownCasting.doanmialStuff(a);
	}

	public static void doanmialStuff(Animal animal) {

		animal.makenoise();

		if (animal instanceof CastingExample) {
			CastingExample c = (CastingExample) animal;

			c.makeothernoise();
		}
	}

}

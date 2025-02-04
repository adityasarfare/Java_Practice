package com.demo.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Executable;
import java.nio.file.NoSuchFileException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Maths Testing")
public class MathUtilsTest {

	 MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to be run before all");
	}
	
	@AfterAll
	static void afterAllInit() {
		System.out.println("This need to be close");
	}
	@BeforeEach
	  void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running" + testInfo.getDisplayName() + "is done"+ testInfo.getTags());
		System.out.println("Object Created");
	}
	
	@Test
	@DisplayName("Testing add method")
	@Tag("Adding of numbers")
	void testAdd() {
//		MathUtils mathUtils = new MathUtils();
		int expected =5;
		int actual = mathUtils.add(1, 4);
		assertEquals(expected, actual, " sum should return " + expected + " of two numbers");
	}
	

	@Test
	@DisplayName("Testing addition of negative method")
	void testAddNegative() {
//		MathUtils mathUtils = new MathUtils();
		
		int actual = mathUtils.add(-1, 0);
		assertEquals(-1, actual, "Should return right sum" );
	}
	
	@Test
//	@EnabledOnOs(OS.LINUX)
	void testDivide() {
//		MathUtils mathUtils = new MathUtils();
//		assertEquals(2, mathUtils.divide(4,2));
//		boolean isServer = false;
//		assumeTrue(isServer);
//		assertEquals(true, isServer);
		assertThrows(ArithmeticException.class, ()->mathUtils.divide(4, 0), "Divide by zero should throw " + ArithmeticException.class + "exception");
	}
	
	@RepeatedTest(3)
//	@Disabled
	void testComputeCircleRadius(RepetitionInfo repetitionInfo) {
//		MathUtils mathUtils = new MathUtils();
		repetitionInfo.getCurrentRepetition();
		assertEquals(50.26548245743669, mathUtils.computeCircleRadius(4), "Should return right circle area");
	}
	
	@Test
	void testMultiply() {
		
		
		assertAll(()-> assertEquals(2, mathUtils.multiply(2, 1)),
				()-> assertEquals(4, mathUtils.multiply(2, 2)),
				()-> assertEquals(4, mathUtils.multiply(2, 2)) 
				);
	}
	
////////// Nested test cases ////////////////////////
	@Nested
	@DisplayName("Adding methods")
	class Addtest{
		
		@Test
		@DisplayName("Testing add method +")
		void testAdd1() {
			assertEquals(4, mathUtils.add(2, 2), "The add method should add two positive numbers");
		}
		
		@Test
		@DisplayName("Testing add method -")
		void testAdd2() {		
			assertEquals(-6, mathUtils.add(-3, -3), "The add method should add two negative numbers");
		}
	}

	
	@Test
	@DisplayName("TDD method should not run")
	@Disabled
	void testDisabled() {
		fail("This test should be disabled");
	}
}



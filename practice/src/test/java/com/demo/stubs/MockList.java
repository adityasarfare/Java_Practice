package com.demo.stubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockList{

	
	@Test
	public void letsMockListSize() {
		 List<Integer> list = Mockito.mock(List.class);
		when(list.size()).thenReturn(0);
		
		assertEquals(0, list.size());
	}
	
	@Test
	public void letsMockListSize_WithMultipleValues() {
		 List<Integer> list = mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, list.size());
		assertEquals(3, list.size());
	}
	
	@Test
	public void letsMockList_get() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("codezilla");
		when(list.get(1)).thenReturn("codedecode");
		assertEquals("codezilla", list.get(0));
		assertEquals("codedecode", list.get(1));
		assertEquals(null, list.get(2));
	}
	
	@Test
	public void letsMockList_WithArgumentMatcher() {
		List<String> list = mock(List.class);
		when(list.get(anyInt())).thenReturn("codezilla");
		
		assertEquals("codezilla", list.get(3));	
	}
	
	@Test()
	public void letsMockList_WhichThrowsException() {
		List<String> list = mock(List.class);
		when(list.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
		
		list.get(1);
	}
}

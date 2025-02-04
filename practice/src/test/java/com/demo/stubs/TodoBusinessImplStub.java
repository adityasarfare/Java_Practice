package com.demo.stubs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TodoBusinessImplStub {

	@Test
	public void testRetrieveTodosRelatedToSpringUsingStubs() {
		
		TodoServiceStub todoServiceStub = new TodoServiceStub();
		
		TodoBusinessImpl todoImpl = new TodoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(3, filteredTodos.size());
		
		
	}
}

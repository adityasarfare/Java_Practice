package com.demo.stubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TodoBusinessImplMock {

	@Test
	public void testRetrieveTodosRelatedToMockito() {
		
		TodoService mock = Mockito.mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Spring boot is used for microservices", "Spring mvc is used for web", 
				"Spring is used for cloud");
		when(mock.retrieveTodos("Dummy")).thenReturn(todos);
		
	     TodoBusinessImpl todoImpl = new TodoBusinessImpl(mock);
	     
	     List<String> filteredTodos =  todoImpl.retrieveTodosRelatedToSpring("Dummy");
	     
	     assertEquals(3, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToMockito_WithEmptyList() {
		
		TodoService mock = Mockito.mock(TodoService.class);
		
		List<String> todos = Arrays.asList();
		when(mock.retrieveTodos("Dummy")).thenReturn(todos);
		
	     TodoBusinessImpl todoImpl = new TodoBusinessImpl(mock);
	     
	     List<String> filteredTodos =  todoImpl.retrieveTodosRelatedToSpring("Dummy");
	     
	     assertEquals(0, filteredTodos.size());
	}
}

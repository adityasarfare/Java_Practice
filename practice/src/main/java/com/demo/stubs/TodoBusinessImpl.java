/**
 * 
 */
package com.demo.stubs;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {

	TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	
	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<>();
		List<String> todos = todoService.retrieveTodos(user);
		for (String todo : todos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}	
		}
		return filteredTodos;
	}
	
	
}

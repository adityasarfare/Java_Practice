package com.demo.stubs;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{

	@Override
	public List<String> retrieveTodos(String user) {
		
		return Arrays.asList("Spring boot is used for microservices", "Spring mvc is used for web", 
				"Spring is used for cloud");
	}
 
}

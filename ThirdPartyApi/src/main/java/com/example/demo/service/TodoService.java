package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import com.example.demo.dto.ToDo;

@Service
@RequiredArgsConstructor
public class TodoService {
	
	 private final String API_BASE_URL = "https://jsonplaceholder.typicode.com";
	 
	 private final RestTemplate restTemplate;
	 
	 public List<ToDo> getAllToDo(){
		 ToDo[] todo = restTemplate.getForObject(API_BASE_URL + "/todos" ,  ToDo[].class );
		 return Arrays.asList(todo);
	 }
	 

	 
	 public ToDo getToDobyId(Long id) {
		    return restTemplate.getForObject(API_BASE_URL + "/todos/" + id, ToDo.class);
		}

	 
	 
	 public ToDo createToDo(ToDo todo) {
		 return restTemplate.postForObject(API_BASE_URL, todo, ToDo.class);
	 }
	 

	    public void updateTodo(Long id, ToDo updatedTodo) {
	        restTemplate.put(API_BASE_URL + "/todos/" + id, updatedTodo);
	    }

	    public void deleteTodo(Long id) {
	        restTemplate.delete(API_BASE_URL + "/todos/" + id);
	    }
	 

}

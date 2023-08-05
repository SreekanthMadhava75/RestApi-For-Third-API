package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import com.example.demo.service.TodoService;
import com.example.demo.dto.ToDo;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	 private final TodoService todoService;

	 @GetMapping()
	 public List<ToDo> getAllTodos(){
		 return todoService.getAllToDo();
	 }

	 
	 @GetMapping("/{id}")
	 public ToDo getTodoById(@PathVariable Long id) {
	     return todoService.getToDobyId(id);
	 }

	 
	 @PostMapping()
	 public ToDo postTodo(@RequestBody ToDo todo) {
		 return todoService.createToDo(todo);
	 }
	 
	 @PutMapping("/{id}")
	 public void updateTodo(@PathVariable Long id, ToDo updateToDo) {
		 todoService.updateTodo(id, updateToDo);
	 }
	 
	 @DeleteMapping("/{id}")
	 public void deleteToDo(@PathVariable Long id) {
		 todoService.deleteTodo(id);
	 }
	 
	 
	 
	 
}

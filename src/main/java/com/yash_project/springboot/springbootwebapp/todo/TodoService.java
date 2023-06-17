package com.yash_project.springboot.springbootwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList();
	private static int todosCount=0;
	static {
		todos.add(new Todo(++todosCount,"in28minutes","Learn AWS Certified!",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"in28minutes","Learn Devops",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"in28minutes","Learn Full Stack Development",LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo> findByUsername(){
		return todos;
	}
	
	public void addTodo(String name,String description,LocalDate date,boolean done) {
		todos.add(new Todo(++todosCount,name,description,date,done));
	}
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		this.deleteTodo(todo.getId());
		todos.add(todo);
	}

	
}

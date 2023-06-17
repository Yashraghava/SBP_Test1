package com.yash_project.springboot.springbootwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
	
		List<Todo> todos = todoService.findByUsername();
		model.put("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String userName = (String) model.get("name");
		Todo todo = new Todo(0,userName,"Default Desc",LocalDate.now().plusYears(1), false); 
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String userName = (String) model.get("name");
		todoService.addTodo(userName, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("youtube")
	public RedirectView gotoYoutube() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://www.youtube.com");
		return redirectView;
	}

	@RequestMapping(value="delete-todo",method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showUpdateTodo(ModelMap model,@RequestParam int id) {
		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String userName = (String) model.get("name");
		LocalDate date = todo.getDate();
		todo.setDate(date);
		todo.setUsername(userName);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	
}

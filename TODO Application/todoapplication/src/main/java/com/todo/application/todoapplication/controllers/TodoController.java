package com.todo.application.todoapplication.controllers;

import com.todo.application.todoapplication.model.Todo;
import com.todo.application.todoapplication.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;

    Random random = new Random();

    @PostMapping
    public ResponseEntity createTodoHandler(@RequestBody Todo todo){
        // create Todo
        logger.info("Create Todo");
        int id = random.nextInt(999999999);
        todo.setId(id);

        // call service to create todo
        Todo newTodo = todoService.createTodo(todo);
        return new ResponseEntity(newTodo, HttpStatus.CREATED); // Handling custom http responses
    }

    /*
    Get All todo values
     */
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        logger.info("inside get all todos");
        List<Todo> allTodos = todoService.getAllTodos();
        logger.info(String.valueOf(allTodos.size()));
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }

    /*
    Get Single Todo based on Id
     */

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int id){
        logger.info("id is {}", id);
        Todo todo = todoService.getTodoById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    /*
    Update todo by id
     */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodoById(@RequestBody Todo todoWithNewDetails, @PathVariable int id){
        Todo todo = todoService.updateTodoById(id, todoWithNewDetails);
        return new ResponseEntity<>(todoWithNewDetails, HttpStatus.CREATED);
    }

    /*
    Delete All Todos
     */

    @DeleteMapping
    public ResponseEntity deleteAllTodos(){
        List<Todo> deletedListTodo = todoService.deleteAllTodos();
        return ResponseEntity.ok(deletedListTodo);
    }

    /*
    Delete Todo By Id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Todo>> deleteTodoById(@PathVariable int id){
        List<Todo> todo = todoService.deleteTodoById(id);
        return ResponseEntity.ok(todo);
    }

}

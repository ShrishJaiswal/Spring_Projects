package com.todo.application.todoapplication.services;

import com.todo.application.todoapplication.model.Todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoService {

    List<Todo> todos = new ArrayList<>();

    public Todo createTodo(Todo todo){

        // create todo...
        todos.add(todo);
        return todo;
    }

    public List<Todo> getAllTodos(){
        return todos;
    }

    public Todo getTodoById(int id) {
       Todo todo =  todos.stream().filter(t->id == t.getId()).findAny().get();
       return todo;
    }

    public Todo updateTodoById(int id, Todo todoWithNewDetails) {
        List<Todo> newUpdatedList = todos.stream().map(t->{
            if (t.getId() == id){
                t.setContent(todoWithNewDetails.getContent());
                t.setStatus(todoWithNewDetails.getStatus());
                t.setTitle(todoWithNewDetails.getTitle());
                return t;
            }else{
                return t;
            }
        }).collect(Collectors.toList());

        todos = newUpdatedList;
        todoWithNewDetails.setId(id);
        return todoWithNewDetails;
    }

    public List<Todo> deleteAllTodos() {
        todos.clear();
        return todos;
    }

    public List<Todo> deleteTodoById(int id) {
        Todo todo = getTodoById(id);
        todos.remove(todo);
        return todos;
    }
}

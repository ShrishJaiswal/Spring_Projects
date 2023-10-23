package com.todo.application.todoapplication.model;

public class Todo {

    private int id;
    private String title;
    private String status;
    private String content;

    public Todo(int id, String title, String content, String status){
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public Todo(){} // Default constructor because above a parametrized-constructor is already declared. So need a default non-parameterized constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


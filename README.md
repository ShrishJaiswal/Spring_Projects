<h1>Spring Projects</h1>
<h3><a href="https://github.com/ShrishJaiswal/Spring_Projects/tree/main/TODO%20Application/todoapplication">Todo Application</h3>
<p>This project demonstrates the basic implementation of connection between client and server. <b>Note: This does not contains connection to any DB but instead uses a List</b></p>
<p>Tools and Framework used :- </p>
<ul>
  <li>Spring Mvc Framework</li>
  <li>Spring initializr (To initialize project)</li>
  <li>Maven</li>
  <li>Postman (For calling api)</li>
  <li>Spring Mvc Web (Dependency)</li>
</ul>
<p>Below are the api request url for ease of access: </p>
<ol>
  <li>Post Todo: http://localhost:8080/todos (Body contains:- {
    "title":"Shower",
    "content":"Daily",
    "status":"Not Done"
})</li>
  <li>Get All Todos: http://localhost:8080/todos</li>
  <li>Get Todo By Id: http://localhost:8080/todos/223380888
</li>
  <li>UpdateTodo: http://localhost:8080/todos/437535680</li>
  <li>Delete All Todo: http://localhost:8080/todos</li>
  <li>Delete Todo By Id: http://localhost:8080/todos/131449476</li>
  <li>Single File Upload Request: http://localhost:8080/file/single (Body contains: form-data with image as key and type as file)</li>
  <li>Multiple File Upload Request: http://localhost:8080/file/multiple (Body contains same as single file upload)</li>
  <li>Image in Response: http://localhost:8080/file/sendimage</li>
</ol>

package com.cristidrincu.rest;

import com.cristidrincu.entity.Todo;
import com.cristidrincu.service.TodoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    @Inject
    TodoService todoService;

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        Todo todo = todoService.find(id);
        return Response.ok(todo).build();
    }

    @GET
    @Path("list")
    public Response getTodos() {
        List<Todo> todos = todoService.getTodos();
        return Response.ok(todos).build();
    }

    @POST
    @Path("new")
    public Response createTodo(Todo todo) {
        Todo newTodo = todoService.create(todo);
        return Response.ok(newTodo).build();
    }

    @PUT
    @Path("update")
    public Response updateTodo(Todo todo) {
        Todo updatedTodo = todoService.update(todo);
        return Response.ok(updatedTodo).build();
    }
}

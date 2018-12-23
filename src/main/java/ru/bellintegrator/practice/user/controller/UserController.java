package ru.bellintegrator.practice.user.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Resource to get user by filter", nickname = "getUserList", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/list")
    public List<UserListView> getUserList(@RequestBody UserListView userListView) {
        return userService.getUserList(userListView);
    }

    @ApiOperation(value = "Resource to get user by ID", nickname = "getUserById", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @GetMapping(value = "/{id}")
    public UserView getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "Resource to update user", nickname = "updateUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/update")
    public ResultView updateUser(@RequestBody UserView user) {
        return userService.updateUser(user);
    }

    @ApiOperation(value = "Resource to create user", nickname = "saveUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping(value = "/save")
    public ResultView saveUser(@RequestBody UserView user) {
        return userService.saveUser(user);
    }
}

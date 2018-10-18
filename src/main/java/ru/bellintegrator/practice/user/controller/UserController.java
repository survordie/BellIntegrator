package ru.bellintegrator.practice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/list")
    public List<UserListView> getUserList(@RequestBody UserListView userListView) {
        return userService.getUserList(userListView);
    }

    @GetMapping(value = "/{id}")
    public UserView getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/update")
    public ResultView updateUser(@RequestBody UserView user) {
        return userService.updateUser(user);
    }

    @PostMapping(value = "/save")
    public ResultView saveUser(@RequestBody UserView user) {
        return userService.saveUser(user);
    }
}

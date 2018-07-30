package ru.bellintegrator.practice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/list")
    public List<UserListView> getUserList(@RequestBody UserListView ulw) {
        return userService.getUserList(ulw);
    }

    @GetMapping(value = "/{id}")
    public UserView getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/update")
    public String updateUser(UserView user){
        return userService.updateUser(user);
    }

    @GetMapping(value = "/save")
    public void saveUser(UserView user){
        userService.saveUser(user);
    }
}

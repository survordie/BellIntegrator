package ru.bellintegrator.practice.user.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService {
    @Override
    public UserView getUserById(long id) {
        return null;
    }

    @Override
    public List<UserListView> getUserList(UserListView ulw) {
        return null;
    }

    @Override
    public String updateUser(UserView user) {
        return null;
    }

    @Override
    public void saveUser(UserView user) {

    }
}

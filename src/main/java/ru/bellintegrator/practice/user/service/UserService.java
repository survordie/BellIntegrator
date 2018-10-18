package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;
import ru.bellintegrator.practice.utils.ResultView;

import java.util.List;

/**
 * Сервис User
 */
public interface UserService {

    /**
     * Получить данные пользователя по id
     *
     * @return user
     */
    UserView getUserById(Long id);

    List<UserListView> getUserList(UserListView userListView);

    ResultView updateUser(UserView user);

    ResultView saveUser(UserView user);
}

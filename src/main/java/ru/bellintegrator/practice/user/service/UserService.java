package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;

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
    UserView getUserById(long id);

    List<UserListView> getUserList(UserListView ulw);

    String updateUser(UserView user);

    void saveUser(UserView user);
}

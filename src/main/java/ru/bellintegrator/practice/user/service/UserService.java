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
     * @param id
     * @return user
     */
    UserView getUserById(Long id);

    /**
     * Получить список пользователей по фильтру
     * @param userListView
     * @return
     */
    List<UserListView> getUserList(UserListView userListView);

    /**
     * Обновить пользователя
     * @param user
     * @return
     */
    ResultView updateUser(UserView user);

    /**
     * Добавить нового пользователя
     * @param user
     * @return
     */
    ResultView saveUser(UserView user);
}

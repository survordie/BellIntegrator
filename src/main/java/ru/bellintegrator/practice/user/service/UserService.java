package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserListView;
import ru.bellintegrator.practice.user.view.UserView;

/**
 * Сервис User
 */
public interface UserService {

/**
 * Получить данные пользователя по id
 *
 * @return user
 */
UserView getUserById(long id, UserView userview);
UserListView getUserList(UserListView ulw);
}

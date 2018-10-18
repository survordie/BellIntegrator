package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;

import java.util.List;

/**
 * DAO для работы с User
 */
public interface UserDao {
    /**
     * Получить все объекты User
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     * Получить User по идентификатору
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * Получить User по фильтру
     *
     * @param officeId
     * @param firstName
     * @param secondName
     * @param middleName
     * @param position
     * @param docCode
     * @param citizenshipCode
     * @return
     */
    List<User> getUserByFilter(Long officeId, String firstName, String secondName, String middleName, String position, String docCode, String citizenshipCode);

    /**
     * Сохранить данные User
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * Обновить данные User
     *
     * @param user
     */
    void updateUser(User user);
}
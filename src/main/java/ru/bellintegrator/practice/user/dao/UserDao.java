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
	List<User> all();

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
	 * @param user
	 * @return
	 */
	User getUserByFilter(User user);

	/**
	* Обновить User
	*
	* @param user
	*/
	void updateUser(User user);

	/**
	* Сохранить User
	*
	* @param user
	*/
	void saveUser(User user);
}
package repositories;

import exceptions.DataAccessException;
import exceptions.UserNotFoundException;
import model.User;

import java.util.List;

public interface UsersRepository {
    void create(User user); // Создание пользователя и запись его в файл

    User findById(String id) throws UserNotFoundException, DataAccessException; // Поиск пользователя в файле по идентификатору

    List<User> findAll(); // Выгрузка всех пользователей из файла

    void update(User user); // Обновление полей существующего в файле пользователя

    void deleteById(String id); // Удаление пользователя по идентификатору

    void deleteAll(); // Удаление всех пользователей
}

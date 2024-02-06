import exceptions.DataAccessException;
import exceptions.InvalidUserDataException;
import exceptions.UserNotFoundException;
import model.User;
import repositories.UsersRepository;

import java.util.List;

public class App {
    public static final int NUMBER_OF_USERS = 10;

    public static void main(String[] args) throws UserNotFoundException, DataAccessException, InvalidUserDataException {
        UsersRepository usersRepository = new UsersRepositoryFileImpl();

        // Генерация и добавление пользователей в репозиторий
        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            User user = UserGenerator.generateRandomUser();
            usersRepository.create(user);
            System.out.println("Создан пользователь: " + user);
        }

        // Выгрузка и отображение всех пользователей
        List<User> allUsers = usersRepository.findAll();
        System.out.println("Все пользователи: ");
        allUsers.forEach(System.out::println);

        // Демонстрация других функций (поиск, обновление, удаление) с использованием первого пользователя
        if (!allUsers.isEmpty()) {
            User firstUser = allUsers.get(0);

            // Поиск первого пользователя
            User foundUser = usersRepository.findById(firstUser.getId());
            System.out.println("Найден пользователь: " + foundUser);

            // Обновление пользователя
            firstUser.setLogin("updated" + firstUser.getLogin());
            usersRepository.update(firstUser);
            System.out.println("Обновленный пользователь: " + usersRepository.findById(firstUser.getId()));

            // Удаление пользователя
            usersRepository.deleteById(firstUser.getId());
            System.out.println("Пользователи после удаления первого пользователя:");
            usersRepository.findAll().forEach(System.out::println);
        }

        // Удаление всех пользователей
        usersRepository.deleteAll();
        System.out.println("Пользователи после полного удаления:");
        usersRepository.findAll().forEach(System.out::println);
    }
}

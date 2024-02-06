import exceptions.DataAccessException;
import exceptions.InvalidUserDataException;
import exceptions.UserNotFoundException;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UsersRepositoryFileImplTest {
    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        usersRepository = new UsersRepositoryFileImpl();
    }

    @Test
    void testCreateUser() {
        User user = new User("1", LocalDateTime.now(), "testuser", "password", "password", "Test", "User", null, 30, true);
        assertDoesNotThrow(() -> usersRepository.create(user));
    }

    @Test
    void testFindUserById() throws InvalidUserDataException, DataAccessException {
        User user = new User("2", LocalDateTime.now(), "testuser2", "password", "password", "Test", "User", null, 30, true);
        usersRepository.create(user);
        assertDoesNotThrow(() -> {
            User foundUser = usersRepository.findById("2");
            assertEquals("testuser2", foundUser.getLogin());
        });
    }

    @Test
    void testFindUserByIdNotFound() {
        assertThrows(UserNotFoundException.class, () -> usersRepository.findById("nonexistentid"));
    }

    @Test
    void testCreateUserWithInvalidData() {
        User invalidUser = new User("", LocalDateTime.now(), "", "", "", "", "", null, -1, true);
        assertThrows(InvalidUserDataException.class, () -> usersRepository.create(invalidUser));
    }

    private static Stream<Arguments> provideInvalidUsers() {
        return Stream.of(
                Arguments.of(new User("", LocalDateTime.now(), "testuser", "password", "password", "Test", "User", null, 30, true), "ID пользователя не может быть пустым"),
                Arguments.of(new User("3", LocalDateTime.now(), "", "password", "password", "Test", "User", null, 30, true), "Логин не может быть пустым"),
                Arguments.of(new User("4", LocalDateTime.now(), "testuser4", "", "", "Test", "User", null, 30, true), "Пароль не может быть пустым"),
                Arguments.of(new User("5", LocalDateTime.now(), "testuser5", "password", "password", "Test", "User", null, 17, true), "Возраст пользователя должен быть не меньше 18 лет")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidUsers")
    void testCreateUserWithInvalidData(User user, String expectedMessage) {
        InvalidUserDataException exception = assertThrows(InvalidUserDataException.class, () -> usersRepository.create(user));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalid_users.csv", numLinesToSkip = 1)
    void testCreateUserWithInvalidDataFromCsv(String id, String login, String password, String lastName, String firstName, String patronymic, Integer age, Boolean isWorker, String expectedMessage) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl();
        User user = new User(id, LocalDateTime.now(), login, password, password, lastName, firstName, patronymic, age, isWorker);
        InvalidUserDataException exception = assertThrows(InvalidUserDataException.class, () -> usersRepository.create(user));
        assertEquals(expectedMessage, exception.getMessage());
    }
}

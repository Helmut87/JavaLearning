import exceptions.DataAccessException;
import exceptions.InvalidUserDataException;
import exceptions.UserNotFoundException;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.UsersRepository;

import java.time.LocalDateTime;

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
}

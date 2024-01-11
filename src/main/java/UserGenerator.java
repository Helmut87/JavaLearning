import com.github.javafaker.Faker;
import model.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserGenerator {
    private static final Faker faker = new Faker();

    public static User generateRandomUser() {
        String id = UUID.randomUUID().toString();
        LocalDateTime dateAdded = LocalDateTime.now();
        String login = "user" + faker.number().numberBetween(999,99999);
        String password = faker.internet().password();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String middleName = faker.name().firstName();
        int age = faker.number().numberBetween(16, 99);
        boolean isWorker = faker.random().nextBoolean();

        return new User(id, dateAdded, login, password, password, lastName, firstName, middleName, age, isWorker);
    }
}

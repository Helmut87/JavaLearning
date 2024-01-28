import impl.CarRepositoryImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements CarRepositoryImpl {
    private static final String FILE_NAME = "src/main/resources/users.txt";
    private final FileDataManager fileDataManager;

    public UsersRepositoryFileImpl() {
        this.fileDataManager = new FileDataManager(FILE_NAME);
    }

    @Override
    public void create(User user) throws InvalidUserDataException, DataAccessException {
        validateUser(user); // Вынесение проверок в отдельный метод
        try {
            fileDataManager.appendLine(userToString(user));
        } catch (IOException e) {
            throw new DataAccessException("Ошибка при записи пользователя в файл", e);
        }
    }

    private void validateUser(User user) throws InvalidUserDataException {
        if (user.getId() == null || user.getId().isEmpty()) {
            throw new InvalidUserDataException("ID пользователя не может быть пустым");
        }
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new InvalidUserDataException("Логин не может быть пустым");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidUserDataException("Пароль не может быть пустым");
        }
        if (user.getAge() < 18) {
            throw new InvalidUserDataException("Возраст пользователя должен быть не меньше 18 лет");
        }
    }

    @Override
    public User findById(String id) throws UserNotFoundException, DataAccessException {
        try {
            List<String> lines = fileDataManager.readAllLines();
            for (String line : lines) {
                User user = stringToUser(line);
                if (user.getId().equals(id)) {
                    return user;
                }
            }
        } catch (IOException e) {
            throw new DataAccessException("Ошибка при доступе к данным файла", e);
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            List<String> lines = fileDataManager.readAllLines();
            for (String line : lines) {
                users.add(stringToUser(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User user) {
        try {
            List<User> users = findAll();
            boolean found = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId().equals(user.getId())) {
                    users.set(i, user);
                    found = true;
                    break;
                }
            }
            if (!found) {
                users.add(user);
            }
            rewriteFile(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            List<User> users = findAll();
            users.removeIf(u -> u.getId().equals(id));
            rewriteFile(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        try {
            fileDataManager.clearFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void rewriteFile(List<User> users) throws IOException {
        List<String> lines = new ArrayList<>();
        for (User user : users) {
            lines.add(userToString(user));
        }
        fileDataManager.writeAllLines(lines);
    }

    private String userToString(User user) {
        return user.getId() + "|" + user.getDateAdded() + "|" + user.getLogin() + "|" + user.getPassword() + "|" +
                user.getConfirmPassword() + "|" + user.getLastName() + "|" + user.getFirstName() + "|" +
                user.getMiddleName() + "|" + user.getAge() + "|" + user.isWorker();
    }

    private User stringToUser(String str) {
        String[] parts = str.split("\\|");
        return new User(parts[0], LocalDateTime.parse(parts[1]), parts[2], parts[3], parts[4], parts[5], parts[6],
                parts[7], parts.length > 8 ? Integer.parseInt(parts[8]) : null, parts.length > 9 && Boolean.parseBoolean(parts[9]));
    }
}

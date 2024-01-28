import cars.Car;
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
    public void create(Car car) throws InvalidUserDataException, DataAccessException {
        validateUser(car); // Вынесение проверок в отдельный метод
        try {
            fileDataManager.appendLine(userToString(car));
        } catch (IOException e) {
            throw new DataAccessException("Ошибка при записи пользователя в файл", e);
        }
    }

    private void validateUser(Car car) throws InvalidUserDataException {
        if (car.getId() == null || car.getId().isEmpty()) {
            throw new InvalidUserDataException("ID пользователя не может быть пустым");
        }
        if (car.getLogin() == null || car.getLogin().isEmpty()) {
            throw new InvalidUserDataException("Логин не может быть пустым");
        }
        if (car.getPassword() == null || car.getPassword().isEmpty()) {
            throw new InvalidUserDataException("Пароль не может быть пустым");
        }
        if (car.getAge() < 18) {
            throw new InvalidUserDataException("Возраст пользователя должен быть не меньше 18 лет");
        }
    }

    @Override
    public Car findById(String id) throws UserNotFoundException, DataAccessException {
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
    public List<Car> findAll() {
        List<Car> users = new ArrayList<>();
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
    public void update(Car car) {
        try {
            List<Car> users = findAll();
            boolean found = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId().equals(car.getId())) {
                    users.set(i, car);
                    found = true;
                    break;
                }
            }
            if (!found) {
                users.add(car);
            }
            rewriteFile(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            List<Car> users = findAll();
            users.removeIf(u -> u.getId().equals(id));
            rewriteFile(cars);
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

    private void rewriteFile(List<Car> users) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Car car : cars) {
            lines.add(userToString(car));
        }
        fileDataManager.writeAllLines(lines);
    }

    private String userToString(Car car) {
        return car.getId() + "|" + car.getDateAdded() + "|" + car.getLogin() + "|" + car.getPassword() + "|" +
                car.getConfirmPassword() + "|" + car.getLastName() + "|" + car.getFirstName() + "|" +
                car.getMiddleName() + "|" + car.getAge() + "|" + car.isWorker();
    }

    private Car stringToUser(String str) {
        String[] parts = str.split("\\|");
        return new Car(parts[0], LocalDateTime.parse(parts[1]), parts[2], parts[3], parts[4], parts[5], parts[6],
                parts[7], parts.length > 8 ? Integer.parseInt(parts[8]) : null, parts.length > 9 && Boolean.parseBoolean(parts[9]));
    }
}

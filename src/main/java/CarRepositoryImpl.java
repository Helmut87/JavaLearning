import cars.Car;
import exceptions.CarNotFoundException;
import exceptions.DataAccessException;
import exceptions.InvalidCarDataException;
import repository.CarRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    private static final String FILE_NAME = "src/main/resources/cars.txt";
    private final FileDataManager fileDataManager;

    public CarRepositoryImpl() {
        this.fileDataManager = new FileDataManager(FILE_NAME);
    }

    @Override
    public void create(Car car) throws InvalidCarDataException, DataAccessException {
        validateCar(car); // Вынесение проверок в отдельный метод
        try {
            fileDataManager.appendLine(carToString(car));
        } catch (IOException e) {
            throw new DataAccessException("Ошибка при записи авто в файл", e);
        }
    }

    private void validateCar(Car car) throws InvalidCarDataException {
        if (car.getId() == null || car.getId().isEmpty()) {
            throw new InvalidCarDataException("ID авто не может быть пустым");
        }
        if (car.getCarModel() == null || car.getCarModel().isEmpty()) {
            throw new InvalidCarDataException("Модель авто не может быть пустой");
        }
        if (car.getCarEnginePower() == 0) {
            throw new InvalidCarDataException("Пароль не может быть пустым");
        }
    }

    @Override
    public Car findById(String id) throws CarNotFoundException, DataAccessException {
        try {
            List<String> lines = fileDataManager.readAllLines();
            for (String line : lines) {
                Car car = stringToCar(line);
                if (car.getId().equals(id)) {
                    return car;
                }
            }
        } catch (IOException e) {
            throw new DataAccessException("Ошибка при доступе к данным файла", e);
        }
        throw new CarNotFoundException(id);
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        try {
            List<String> lines = fileDataManager.readAllLines();
            for (String line : lines) {
                cars.add(stringToCar(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public void update(Car car) {
        try {
            List<Car> cars = findAll();
            boolean found = false;
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getId().equals(car.getId())) {
                    cars.set(i, car);
                    found = true;
                    break;
                }
            }
            if (!found) {
                cars.add(car);
            }
            rewriteFile(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            List<Car> cars = findAll();
            cars.removeIf(u -> u.getId().equals(id));
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

    private void rewriteFile(List<Car> cars) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Car car : cars) {
            lines.add(carToString(car));
        }
        fileDataManager.writeAllLines(lines);
    }

    private String carToString(Car car) {
        return car.getId() + "|" + car.getCarBrand() + "|" + car.getCarModel() + "|" + car.getCarYearOfProduction() + "|" +
                car.getCarEnginePower() + "|" + car.getCarAccelerate() + "|" + car.getCarSuspension() + "|" +
                car.getCarDurability();
    }

    private Car stringToCar(String str) {
        String[] parts = str.split("\\|");
        return new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
    }
}
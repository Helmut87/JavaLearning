package repository;

import model.Car;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Метод getAllCars возвращает список всех автомобилей
 * Метод saveCars сохраняет автомобиль
 **/

public class CarsRepositoryImpl implements CarsRepository {
    private final String fileName;

    public CarsRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Car> getAllCars() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(CarUtils::createCarFromString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveCars(List<Car> cars) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                writer.write(car.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Во время сохранения автомобиля произошла ошибка! " + e);
        }
    }
}

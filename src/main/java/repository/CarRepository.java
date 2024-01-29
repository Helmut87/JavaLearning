package repository;

import cars.Car;
import exceptions.DataAccessException;
import exceptions.InvalidCarDataException;
import exceptions.CarNotFoundException;

import java.util.List;

public interface CarRepository {
    void create(Car car) throws InvalidCarDataException, DataAccessException; // Создание авто и запись его в файл

    Car findById(String id) throws CarNotFoundException, DataAccessException; // Поиск авто в файле по идентификатору

    List<Car> findAll(); // Выгрузка всех авто из файла

    void update(Car car); // Обновление полей существующего в файле авто

    void deleteById(String id); // Удаление авто по идентификатору

    void deleteAll(); // Удаление всех авто
}

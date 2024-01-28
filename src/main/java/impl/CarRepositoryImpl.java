package impl;

import cars.Car;

import java.util.List;

public interface CarRepositoryImpl {
    void create(Car car) throws InvalidUserDataException, DataAccessException; // Создание авто и запись его в файл

    Car findById(String id) throws UserNotFoundException, DataAccessException; // Поиск авто в файле по идентификатору

    List<Car> findAll(); // Выгрузка всех авто из файла

    void update(Car car); // Обновление полей существующего в файле авто

    void deleteById(String id); // Удаление авто по идентификатору

    void deleteAll(); // Удаление всех авто
}

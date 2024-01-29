import cars.Car;
import cars.CarGenerator;
import cars.PerformanceCar;
import cars.ShowCar;
import com.github.javafaker.Faker;
import exceptions.CarNotFoundException;
import exceptions.DataAccessException;
import exceptions.InvalidCarDataException;
import garages.Garage;
import races.CasualRace;
import races.Race;
import races.TimeLimitRace;
import repository.CarRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class App {
    public static final int NUMBER_OF_CARS = 1;
    private static Garage garage;

    public static void main(String[] args) throws InvalidCarDataException, DataAccessException, CarNotFoundException {
        CarRepository carRepository = new CarRepositoryImpl();

        // Генерация и добавление авто в репозиторий и добавление авто в гараж
        for (int i = 0; i < NUMBER_OF_CARS; i++) {
            Car simpleCar = CarGenerator.createSimpleCar();
            PerformanceCar performanceCar = CarGenerator.createPerformanceCar();
            ShowCar showCar = CarGenerator.createShowCar();
            carRepository.create(simpleCar);
            carRepository.create(performanceCar);
            carRepository.create(showCar);
            garage = new Garage();
            garage.parkCar(simpleCar);
            garage.parkCar(performanceCar);
            garage.parkCar(showCar);
        }

        // Выгрузка и отображение всех авто
        List<Car> allCars = carRepository.findAll();
        System.out.println("Все авто: ");
        allCars.forEach(System.out::println);

        if (!allCars.isEmpty()) {
            Car firstCar = allCars.get(0);

            // Поиск первого авто
            Car foundCar = carRepository.findById(firstCar.getId());
            System.out.println("Найден пользователь: " + foundCar);

            // Обновление авто
            firstCar.setCarBrand("updated" + firstCar.getCarBrand());
            carRepository.update(firstCar);
            System.out.println("Обновленный авто: " + carRepository.findById(firstCar.getId()));

            // Удаление авто
            carRepository.deleteById(firstCar.getId());
            System.out.println("Авто после удаления первого автомобиля:");
            carRepository.findAll().forEach(System.out::println);
        }

        System.out.println("Машины на парковке в гараже:");
        for (Car parkedCar : garage.getParkedCars()) {
            System.out.println(parkedCar);
        }
//        // Удаление всех авто
//        carRepository.deleteAll();
//        carRepository.findAll().forEach(System.out::println);

    }
}

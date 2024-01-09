package test;

import model.Car;
import repository.CarsRepository;
import repository.CarsRepositoryImpl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CarsRepository carsRepository = new CarsRepositoryImpl("src/main/java/data/cars.txt");
        List<Car> cars = carsRepository.getAllCars();

        // Если список пуст, создадим и добавим несколько автомобилей
        if (cars.isEmpty()) {
            Car car1 = new Car("a123me", "Mercedes", "White", 0, 8300000);
            Car car2 = new Car("b873of", "Volga", "Black", 0, 673000);
            Car car3 = new Car("w487mn", "Lexus", "Grey", 76000, 900000);
            Car car4 = new Car("p987hj", "Volga", "Red", 610, 704340);
            Car car5 = new Car("c987ss", "Toyota", "White", 254000, 761000);
            Car car6 = new Car("o983op", "Toyota", "Black", 698000, 740000);
            Car car7 = new Car("p146op", "BMW", "White", 271000, 850000);
            Car car8 = new Car("u893ii", "Toyota", "Purple", 210900, 440000);
            Car car9 = new Car("l097df", "Toyota", "Black", 108000, 780000);
            Car car10 = new Car("y876wd", "Toyota", "Black", 160000, 1000000);

            cars.addAll(Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10));

            carsRepository.saveCars(cars);
        }

        //Номера всех автомобилей, имеющих заданный цвет или нулевой пробег
        String colorToFind = "Black";
        int mileageToFind = 0;
        List<String> carNumbers = cars.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getCarNumber).toList();
        System.out.println("Номера автомобилей с цветом " + colorToFind + " или нулевым пробегом: " + carNumbers);

        //Количество уникальных моделей в ценовом диапазоне от n до m тыс.
        double n = 700000;
        double m = 800000;
        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getCost() >= n && car.getCost() <= m)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("Количество уникальных моделей в ценовом диапазоне от " + n + " до " + m + " тыс.: " + uniqueModelsCount);

        //Вывести цвет автомобиля с минимальной стоимостью
        String minCostColor = cars.stream()
                .min(Comparator.comparingDouble(Car::getCost))
                .map(Car::getColor)
                .orElse("Unknown");
        System.out.println("Цвет автомобиля с минимальной стоимостью: " + minCostColor);

        //Средняя стоимость искомой модели
        List<String> modelsToFind = Arrays.asList("Toyota", "Volvo");
        Map<String, Double> averageCostByModel = modelsToFind.stream()
                .collect(Collectors.toMap(
                        model -> model,
                        model -> cars.stream()
                                .filter(car -> car.getModel().equals(model))
                                .mapToDouble(Car::getCost)
                                .average()
                                .orElse(0.0)));
        System.out.println("Средняя стоимость для моделей: " + averageCostByModel);
    }
}

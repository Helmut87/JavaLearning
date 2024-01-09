import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/cars.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Car car = new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                cars.add(car);
            }
        } catch (IOException e) {
            System.out.println("Во время чтения из файла произошла ошибка: " + e);
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

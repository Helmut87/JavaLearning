import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>(Arrays.asList(
                new Car("123ABC", "Toyota", "Black", 10000, 500000),
                new Car("456DEF", "Volvo", "White", 0, 750000),
                new Car("789GHI", "Honda", "Red", 5000, 800000)
        ));
    }

    @Test
    void testCarsWithSpecificColorOrZeroMileage() {
        String colorToFind = "Black";
        int mileageToFind = 0;

        List<String> carNumbers = cars.stream()
                .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getCarNumber).toList();

        assertTrue(carNumbers.contains("123ABC") && carNumbers.contains("456DEF"));
    }

    @Test
    void testUniqueModelsInPriceRange() {
        double n = 700000;
        double m = 800000;

        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getCost() >= n && car.getCost() <= m)
                .map(Car::getModel)
                .distinct()
                .count();

        assertEquals(2, uniqueModelsCount);
    }

    @Test
    void testCarColorWithMinimumCost() {
        String minCostColor = cars.stream()
                .min(Comparator.comparingDouble(Car::getCost))
                .map(Car::getColor)
                .orElse("Unknown");

        assertEquals("Black", minCostColor);
    }

    @Test
    void testAverageCostOfSpecificModels() {
        List<String> modelsToFind = Arrays.asList("Toyota", "Volvo");

        Map<String, Double> averageCostByModel = modelsToFind.stream()
                .collect(Collectors.toMap(
                        model -> model,
                        model -> cars.stream()
                                .filter(car -> car.getModel().equals(model))
                                .mapToDouble(Car::getCost)
                                .average()
                                .orElse(0.0)));

        assertEquals(500000.0, averageCostByModel.get("Toyota"), 0.01);
        assertEquals(750000.0, averageCostByModel.get("Volvo"), 0.01);
    }


}

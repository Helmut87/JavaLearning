import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceNegativeTest {
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
    void testWithInvalidPriceRange() {
        double n = -100000; // Invalid price range
        double m = -50000;

        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getCost() >= n && car.getCost() <= m)
                .map(Car::getModel)
                .distinct()
                .count();

        assertEquals(0, uniqueModelsCount);
    }
}

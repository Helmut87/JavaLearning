import cars.Car;
import garages.Garage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CarPositiveTests {
    @Test
    public void testSimpleCarCreation() {
        Car simpleCar = new Car("Ferrari", "F150", 2000, 200, 5, 10, 50);
        assertNotNull(simpleCar);
        assertEquals("Ferrari", simpleCar.getCarBrand());
    }

    @Test
    public void testGarageParking() {
        Car simpleCar = new Car("Ferrari", "F150", 2000, 200, 5, 10, 50);
        Garage garage = new Garage();
        garage.parkCar(simpleCar);
        assertFalse(garage.getParkedCars().isEmpty());
    }

    @ParameterizedTest
    @MethodSource("validCarParameters")
    void testCarConstructorWithValidParameters(String brand, String model, int year, int power, int accelerate, int suspension, int durability) {
        assertDoesNotThrow(() -> new Car(brand, model, year, power, accelerate, suspension, durability));
    }

    private static Stream<Arguments> validCarParameters() {
        return Stream.of(
                Arguments.of("Toyota", "Corolla", 2020, 100, 10, 15, 80),
                Arguments.of("Ford", "Mustang", 2019, 150, 8, 20, 85)
        );
    }
}

import cars.Car;
import garages.Garage;
import org.junit.jupiter.api.Test;

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
}

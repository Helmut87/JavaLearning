import cars.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNegativeTests {
    @Test
    public void testInvalidCarCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Car("Ferrari", "F150", -1000, 200, 5, 10, 50));
    }

    @Test
    public void testInvalidCarEnginePower() {
        assertThrows(IllegalArgumentException.class, () -> new Car("Ferrari", "F150", 1987, -200, 5, 10, 50));
    }
}


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarExceptionTests {
    @Test
    public void testFileReadingException() {
        CarService carService = new CarService();
        assertThrows(IOException.class, () -> carService.readCarsFromFile("non_existent_file.txt"));
    }

    @Test
    public void testNumberFormatException() {
        CarService carService = new CarService();
        assertThrows(NumberFormatException.class, () -> carService.readCarsFromFile("src/test/resources/cars_negative.txt"));
    }
}
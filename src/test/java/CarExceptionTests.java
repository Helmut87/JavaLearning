import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("provideFileNamesForIOExceptionTest")
    public void testFileReadingException(String fileName, Class<Exception> expectedException) {
        CarService carService = new CarService();
        assertThrows(expectedException, () -> carService.readCarsFromFile(fileName));
    }

    private static Stream<Arguments> provideFileNamesForIOExceptionTest() {
        return Stream.of(
                Arguments.of("non_existent_file.txt", IOException.class),
                Arguments.of("src/test/resources/cars_negative.txt", NumberFormatException.class)
        );
    }
}
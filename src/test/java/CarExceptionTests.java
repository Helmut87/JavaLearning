import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarExceptionTests {
    @Test
    public void testFileReadingException() {
        assertThrows(IOException.class, () -> new BufferedReader(new FileReader("non_existent_file.txt")));
    }

    @Test
    public void testNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/cars.txt"));
            Integer.parseInt(reader.readLine());
        });
    }
}


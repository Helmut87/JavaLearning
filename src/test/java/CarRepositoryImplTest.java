import cars.Car;
import exceptions.CarNotFoundException;
import exceptions.DataAccessException;
import exceptions.InvalidCarDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarRepositoryImplTest {

    @Mock
    private FileDataManager fileDataManager;
    private CarRepositoryImpl carRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        carRepository = new CarRepositoryImpl(fileDataManager);
    }

    private List<Car> loadCarsFromFile(String fileName) {
        try {
            URL resource = getClass().getClassLoader().getResource(fileName);
            if (resource == null) {
                throw new IllegalArgumentException("file not found! " + fileName);
            } else {
                Path path = Paths.get(resource.toURI());
                List<String> lines = Files.readAllLines(path);
                return lines.stream().map(this::stringToCar).collect(Collectors.toList());
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Failed to load cars from file", e);
        }
    }

    private Car stringToCar(String str) {
        String[] parts = str.split("\\|");
        return new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]));
    }

    @Test
    void testCreateValidCar() throws IOException, InvalidCarDataException, DataAccessException, URISyntaxException {
        List<Car> cars = loadCarsFromFile("car_data.txt");
        Car car = cars.get(0);
        carRepository.create(car);
        verify(fileDataManager).appendLine("1|Ferrari|F150|1990|400|3|7|3");
    }


    @Test
    void testCreateInvalidCar() {
        Car car = new Car("", "Brand", "Model", 2020, 100, 5, 5, 5);
        assertThrows(InvalidCarDataException.class, () -> carRepository.create(car));
    }

    @Test
    void testFindByIdFound() throws IOException, CarNotFoundException, DataAccessException {
        when(fileDataManager.readAllLines()).thenReturn(List.of("1|Toyota|Camry|2021|200|5|7|8"));
        Car foundCar = carRepository.findById("1");
        assertNotNull(foundCar);
        assertEquals("1", foundCar.getId());
    }

    @Test
    void testFindByIdNotFound() throws IOException {
        when(fileDataManager.readAllLines()).thenReturn(List.of("1|Toyota|Camry|2021|200|5|7|8"));
        assertThrows(CarNotFoundException.class, () -> carRepository.findById("2"));
    }

    @Test
    void testDeleteById() throws IOException {
        when(fileDataManager.readAllLines()).thenReturn(List.of("1|Toyota|Camry|2021|200|5|7|8"));
        doNothing().when(fileDataManager).writeAllLines(anyList());

        assertDoesNotThrow(() -> carRepository.deleteById("1"));
        verify(fileDataManager, times(1)).writeAllLines(anyList());
    }
}

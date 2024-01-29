import cars.Car;
import com.github.javafaker.Faker;
import exceptions.CarNotFoundException;
import exceptions.DataAccessException;
import exceptions.InvalidCarDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
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

    @Test
    void testCreateValidCar() throws IOException, InvalidCarDataException, DataAccessException {
        Car car = new Car("1", "Ferrari", "F150", 1990, 400, 3, 7, 3);
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

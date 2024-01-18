import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    public List<Car> readCarsFromFile(String filePath) throws IOException {
        List<Car> cars = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    Car car = new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                    cars.add(car);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Ошибка при парсинге файла: " + e.getMessage());
                }
            }
        }

        return cars;
    }
}

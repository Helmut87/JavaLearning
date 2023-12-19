package repository;

import model.Car;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {
    private final String fileName;

    public CarsRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Car> getAllCars() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> {
                        String[] parts = line.split(" ");
                        return new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveCars(List<Car> cars) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                String line = String.format("%s %s %s %d %.2f%n", car.getCarNumber(), car.getModel(), car.getColor(), car.getMileage(), car.getCost());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

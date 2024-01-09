package repository;

import model.Car;

public class CarUtils {
    public static Car createCarFromString(String line) {
        String[] parts = line.split("\\s");
        return new Car(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
    }
}

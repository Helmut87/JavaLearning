package garages;

import cars.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Garage {
    private ArrayList<Car> parkedCars;

    public void parkCar(Car car) {
        if (parkedCars == null) {
            parkedCars = new ArrayList<>();
        }
        parkedCars.add(car);
    }

    // Удалить автомобиль из гаража
    public void unParkCar(Car car) {
        if (parkedCars != null) {
            parkedCars.remove(car);
        }
    }
}

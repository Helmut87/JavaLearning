package garages;

import cars.Car;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Car> parkedCars;

    public Garage() {
    }

    public Garage(ArrayList<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public ArrayList<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(ArrayList<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

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

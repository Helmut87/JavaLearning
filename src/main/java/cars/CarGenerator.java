package cars;

import com.github.javafaker.Faker;

import java.util.ArrayList;

public class CarGenerator {
    private static final Faker randomValue = new Faker();

    public static Car createSimpleCar() {
        return new Car(
                randomValue.code().asin(),
                randomValue.app().name(),
                randomValue.random().hex(4),
                randomValue.number().numberBetween(1950, 2023),
                randomValue.number().numberBetween(100, 300),
                randomValue.number().numberBetween(3, 10),
                randomValue.number().numberBetween(3, 20),
                randomValue.number().numberBetween(25, 100));
    }

    public static PerformanceCar createPerformanceCar() {
        PerformanceCar performanceCar = new PerformanceCar(
                randomValue.code().asin(),
                randomValue.app().name(),
                randomValue.random().hex(4),
                randomValue.number().numberBetween(1987, 2023),
                randomValue.number().numberBetween(100, 300),
                randomValue.number().numberBetween(3, 10),
                randomValue.number().numberBetween(3, 20),
                randomValue.number().numberBetween(25, 100));
        ArrayList<String> addOns = new ArrayList<>();
        addOns.add("Спортивный спойлер");
        addOns.add("Низкопрофильная резина");
        performanceCar.setAddOns(addOns);

        return performanceCar;
    }

    public static ShowCar createShowCar() {
        return new ShowCar(
                randomValue.code().asin(),
                randomValue.app().name(),
                randomValue.random().hex(4),
                randomValue.number().numberBetween(2000, 2023),
                randomValue.number().numberBetween(100, 300),
                randomValue.number().numberBetween(3, 10),
                randomValue.number().numberBetween(3, 20),
                randomValue.number().numberBetween(25, 100),
                randomValue.number().numberBetween(1, 10)
        );
    }
}

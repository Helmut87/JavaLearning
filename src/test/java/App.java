import cars.Car;
import cars.PerformanceCar;
import cars.ShowCar;
import com.github.javafaker.Faker;
import garages.Garage;
import races.CasualRace;
import races.Race;

import java.util.ArrayList;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Locale locale = new Locale("ru_Ru");
        Faker randomValue = new Faker(locale);

        // ������� ��������� �����������
        Car simpleCar = new Car("Ferrari", "F150",
                randomValue.number().numberBetween(1950, 2023),
                randomValue.number().numberBetween(100, 300),
                randomValue.number().numberBetween(3, 10),
                randomValue.number().numberBetween(3, 20),
                randomValue.number().numberBetween(25, 100));
        PerformanceCar performanceCar = new PerformanceCar("McLauren", "720s",
                randomValue.number().numberBetween(1987, 2023),
                randomValue.number().numberBetween(100, 300),
                randomValue.number().numberBetween(3, 10),
                randomValue.number().numberBetween(3, 20),
                randomValue.number().numberBetween(25, 100));
        ArrayList<String> addOns = new ArrayList<>();
        addOns.add("���������� �������");
        addOns.add("��������������� ������");
        performanceCar.setAddOns(addOns);

        ShowCar showCar = new ShowCar("Renault", "Captur",
                randomValue.number().numberBetween(2000, 2023),
                randomValue.number().numberBetween(100, 300),
                randomValue.number().numberBetween(3, 10),
                randomValue.number().numberBetween(3, 20),
                randomValue.number().numberBetween(25, 100),
                randomValue.number().numberBetween(1, 10)
        );

        // ������� ����� � ��������� ����������
        Garage garage = new Garage();
        garage.parkCar(simpleCar);
        garage.parkCar(performanceCar);
        garage.parkCar(showCar);

        System.out.println("������ �� �������� � ������:");
        for (Car parkedCar : garage.getParkedCars()) {
            System.out.println(parkedCar);
        }

        ArrayList<Car> raceParticipants = new ArrayList<>();
        raceParticipants.add(simpleCar);
        raceParticipants.add(performanceCar);
        raceParticipants.add(showCar);

        String routeName = "����� ������ " + randomValue.address().cityName();

        Race casualRace = new CasualRace(randomValue.number().numberBetween(10, 50), routeName,
                randomValue.number().numberBetween(10000, 100000), raceParticipants);
        System.out.println("\n���������� � �����:");
        System.out.println(casualRace);
    }
}
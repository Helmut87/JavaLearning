import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String carNumber;
    private String model;
    private String color;
    private int mileage;
    private double cost;

    @Override
    public String toString() {
        return "Автомобиль {" +
                "номер автомобиля: '" + carNumber + '\'' +
                ", модель: '" + model + '\'' +
                ", цвет: '" + color + '\'' +
                ", пробег: " + mileage +
                ", стоимость: " + cost +
                '}';
    }
}
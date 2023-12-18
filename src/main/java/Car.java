import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private String carNumber;
    private String model;
    private String color;
    private int mileage;
    private double cost;

    @Override
    public String toString() {
        return "���������� {" +
                "����� ����������: '" + carNumber + '\'' +
                ", ������: '" + model + '\'' +
                ", ����: '" + color + '\'' +
                ", ������: " + mileage +
                ", ���������: " + cost +
                '}';
    }
}
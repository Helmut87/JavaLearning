package model;

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
        return String.format("%s %s %s %d %.2f", carNumber, model, color, mileage, cost);
    }
}
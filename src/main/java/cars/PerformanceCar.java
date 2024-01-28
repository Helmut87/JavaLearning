package cars;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class PerformanceCar extends Car {
    private ArrayList<String> addOns;

    public PerformanceCar(String carBrand, String carModel, int carYearOfProduction, int carEnginePower, int carAccelerate, int carSuspension, int carDurability) {
        super(carBrand, carModel, carYearOfProduction, carEnginePower, carAccelerate, carSuspension, carDurability);
        this.addOns = new ArrayList<>();
        this.setCarEnginePower((int) (carEnginePower * 1.5));
        this.setCarSuspension((int) (carSuspension * 0.75));
    }

    @Override
    public String toString() {
        return "марка = '" + getCarBrand() + '\'' +
                ", модель = '" + getCarModel() + '\'' +
                ", год выпуска = " + getCarYearOfProduction() + " г" +
                ", мощность двигателя = " + getCarEnginePower() + " л/с" +
                ", разгон = " + getCarAccelerate() + " с" +
                ", подвеска = " + getCarSuspension() + " см" +
                ", долговечность = " + getCarDurability() + " %" +
                ", доп. опции = " + addOns;
    }
}
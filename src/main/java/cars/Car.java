package cars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String carBrand;
    private String carModel;
    private int carYearOfProduction;
    private int carEnginePower;
    private int carAccelerate;
    private int carSuspension;
    private int carDurability;

    @Override
    public String toString() {
        return "марка = '" + carBrand + '\'' +
                ", модель = '" + carModel + '\'' +
                ", год выпуска = " + carYearOfProduction + " г" +
                ", мощность двигателя = " + carEnginePower + " л/с" +
                ", разгон = " + carAccelerate + " с" +
                ", подвеска = " + carSuspension + " см" +
                ", долговечность = " + carDurability + " %";
    }
}


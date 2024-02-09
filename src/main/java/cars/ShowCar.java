package cars;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShowCar extends Car {
    private int stars;

    public ShowCar(String id, String carBrand, String carModel, int carYearOfProduction, int carEnginePower, int carAccelerate, int carSuspension, int carDurability, int stars) {
        super(id, carBrand, carModel, carYearOfProduction, carEnginePower, carAccelerate, carSuspension, carDurability);
        this.stars = stars;
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
                ", звезд = " + stars;
    }
}
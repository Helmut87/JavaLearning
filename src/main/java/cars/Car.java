package cars;

public class Car {
    private String carBrand;
    private String carModel;
    private int carYearOfProduction;
    private int carEnginePower;
    private int carAccelerate;
    private int carSuspension;
    private int carDurability;

    public Car() {
    }

    public Car(String carBrand, String carModel, int carYearOfProduction, int carEnginePower,
               int carAccelerate, int carSuspension, int carDurability) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carYearOfProduction = carYearOfProduction;
        this.carEnginePower = carEnginePower;
        this.carAccelerate = carAccelerate;
        this.carSuspension = carSuspension;
        this.carDurability = carDurability;
        if (carYearOfProduction < 1886 || carYearOfProduction > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("Invalid year of production");
        }
        if (carEnginePower < 0 || carAccelerate < 0 || carSuspension < 0 || carDurability < 0) {
            throw new IllegalArgumentException("Car specifications must be non-negative");
        }
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarYearOfProduction() {
        return carYearOfProduction;
    }

    public void setCarYearOfProduction(int carYearOfProduction) {
        this.carYearOfProduction = carYearOfProduction;
    }

    public int getCarEnginePower() {
        return carEnginePower;
    }

    public void setCarEnginePower(int carEnginePower) {
        this.carEnginePower = carEnginePower;
    }

    public int getCarAccelerate() {
        return carAccelerate;
    }

    public void setCarAccelerate(int carAccelerate) {
        this.carAccelerate = carAccelerate;
    }

    public int getCarSuspension() {
        return carSuspension;
    }

    public void setCarSuspension(int carSuspension) {
        this.carSuspension = carSuspension;
    }

    public int getCarDurability() {
        return carDurability;
    }

    public void setCarDurability(int carDurability) {
        this.carDurability = carDurability;
    }

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


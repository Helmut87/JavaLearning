package cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String carBrand, String carModel, int carYearOfProduction, int carEnginePower, int carAccelerate, int carSuspension, int carDurability, int stars) {
        super(carBrand, carModel, carYearOfProduction, carEnginePower, carAccelerate, carSuspension, carDurability);
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "����� = '" + getCarBrand() + '\'' +
                ", ������ = '" + getCarModel() + '\'' +
                ", ��� ������� = " + getCarYearOfProduction() + " �" +
                ", �������� ��������� = " + getCarEnginePower() + " �/�" +
                ", ������ = " + getCarAccelerate() + " �" +
                ", �������� = " + getCarSuspension() + " ��" +
                ", ������������� = " + getCarDurability() + " %" +
                ", ����� = " + stars;
    }
}
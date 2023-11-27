package cars;

import java.util.ArrayList;

public class PerformanceCar extends Car {
    private ArrayList<String> addOns;

    public ArrayList<String> getAddOns() {
        return addOns;
    }

    public void setAddOns(ArrayList<String> addOns) {
        this.addOns = addOns;
    }

    public PerformanceCar(String carBrand, String carModel, int carYearOfProduction, int carEnginePower, int carAccelerate, int carSuspension, int carDurability) {
        super(carBrand, carModel, carYearOfProduction, carEnginePower, carAccelerate, carSuspension, carDurability);
        this.addOns = new ArrayList<>();
        this.setCarEnginePower((int) (carEnginePower * 1.5));
        this.setCarSuspension((int) (carSuspension * 0.75));
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
                ", ���. ����� = " + addOns;
    }
}
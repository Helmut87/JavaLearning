public class Television {

    private String brand;
    private int yearOfProduction;
    private int screenSize;
    private Boolean isSmartTV;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setSmartTV(Boolean smartTV) {
        isSmartTV = smartTV;
    }

    public Television(String brand, int yearOfProduction, int screenSize, Boolean isSmartTV) {
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        this.screenSize = screenSize;
        this.isSmartTV = isSmartTV;
    }

    @Override
    public String toString() {
        return "Название телевизора: " + brand +
                ", собран в: " + yearOfProduction + " году" +
                ", разрешение экрана: " + screenSize + " пикселей" +
                ", присутствует ли smartTv: " + isSmartTV;
    }
}

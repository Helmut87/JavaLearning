package standartlib;

import java.util.Objects;

public class Television {

    private String brand;
    private int yearOfProduction;
    private int screenSize;
    private Boolean isSmartTV;
    private Boolean isTVon;
    private int channelNumber;
    private int volumeLevel;

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

    public void setTVon(Boolean TVon) {
        isTVon = TVon;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    public void setVolumeLevel(int volumeLevel) {
        if (volumeLevel < 0 || volumeLevel > 100) {
            throw new IllegalArgumentException("Громкость звука не может принимать данное значение");
        } else {
            this.volumeLevel = volumeLevel;
        }
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public Boolean getTVon() {
        return isTVon;
    }

    public Television(String brand, int yearOfProduction, int screenSize, Boolean isSmartTV, Boolean isTVon, int channelNumber, int volumeLevel) {
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        this.screenSize = screenSize;
        this.isSmartTV = isSmartTV;
        this.isTVon = isTVon;
        this.channelNumber = channelNumber;
        this.volumeLevel = volumeLevel;
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television television = (Television) o;
        return yearOfProduction == television.yearOfProduction &&
                screenSize == television.screenSize &&
                Objects.equals(brand, television.brand) &&
                Objects.equals(isSmartTV, television.isSmartTV) &&
                Objects.equals(isTVon, television.isTVon) &&
                channelNumber == television.channelNumber &&
                volumeLevel == television.volumeLevel;
    }

    // hashCode method
    @Override
    public int hashCode() {
        int result = brand == null ? 0 : brand.hashCode();
        result = 31 * result + yearOfProduction;
        result = 31 * result + screenSize;
        result = 31 * result + (isSmartTV ? 1 : 0);
        result = 31 * result + (isTVon ? 1 : 0);
        result = 31 * result + channelNumber;
        result = 31 * result + volumeLevel;
        return result;
    }

    // toString method
    @Override
    public String toString() {
        return "Television {" +
                "className= " + getClass().getSimpleName() +
                ", brand= '" + brand + '\'' +
                ", yearOfProduction= " + yearOfProduction +
                ", screenSize= " + screenSize +
                ", isSmartTV= " + isSmartTV +
                ", isTVon= " + isTVon +
                ", channelNumber= " + channelNumber +
                ", volumeLevel= " + volumeLevel +
                '}';
    }
}

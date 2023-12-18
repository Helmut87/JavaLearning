package externallib;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import standartlib.Television;

import java.util.Objects;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelevisionWithLombok {

    private String brand;
    private int yearOfProduction;
    private int screenSize;
    private Boolean isSmartTV;
    private Boolean isTVon;
    private int channelNumber;
    private int volumeLevel;

    public void setVolumeLevel(int volumeLevel) {
        if (volumeLevel < 0 || volumeLevel > 100) {
            throw new IllegalArgumentException("Громкость звука не может принимать данное значение");
        } else {
            this.volumeLevel = volumeLevel;
        }
    }
    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelevisionWithLombok television = (TelevisionWithLombok) o;
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

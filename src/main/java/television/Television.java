package television;

import java.util.ArrayList;
import java.util.Objects;

public class Television {
    private String brand;
    private int yearOfProduction;
    private int screenSize;
    private boolean isSmartTV;
    private boolean isTVon;
    private int currentChannel;
    private int volumeLevel;
    private ArrayList<Channel> channels;

    public Television(String brand, int yearOfProduction, int screenSize, boolean isSmartTV, boolean isTVon, int channelNumber, int volumeLevel) {
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        this.screenSize = screenSize;
        this.isSmartTV = isSmartTV;
        this.isTVon = isTVon;
        this.currentChannel = channelNumber;
        this.volumeLevel = volumeLevel;
        this.channels = new ArrayList<>();
    }

    public void addChannel(Channel channel) {
        channels.add(channel);
    }

    public void togglePower() {
        isTVon = !isTVon;
    }

    public void changeChannel(int channelNumber) {
        if (isTVon) {
            currentChannel = channelNumber;
        }
    }

    public boolean getTVon() {
        return isTVon;
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public Television() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return yearOfProduction == that.yearOfProduction &&
                screenSize == that.screenSize &&
                isSmartTV == that.isSmartTV &&
                isTVon == that.isTVon &&
                currentChannel == that.currentChannel &&
                volumeLevel == that.volumeLevel &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(channels, that.channels);
    }

    @Override
    public int hashCode() {
        int result = brand == null ? 0 : brand.hashCode();
        result = 31 * result + yearOfProduction;
        result = 31 * result + screenSize;
        result = 31 * result + (isSmartTV ? 1 : 0);
        result = 31 * result + (isTVon ? 1 : 0);
        result = 31 * result + currentChannel;
        result = 31 * result + volumeLevel;
        for (Channel channel : channels) {
            result = 31 * result + (channel == null ? 0 : channel.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return "Телевизор {" +
                "марка ='" + brand + '\'' +
                ", год производства =" + yearOfProduction +
                ", размер экрана =" + screenSize +
                ", функция SmartTv=" + isSmartTV +
                ", телевизор включен =" + isTVon +
                ", текущий канал =" + currentChannel +
                ", уровень громкости =" + volumeLevel +
                ", каналы =" + channels +
                '}';
    }
}

package races;

import cars.Car;

import java.util.ArrayList;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace() {
    }

    public TimeLimitRace(int raceLength, String raceRoute, int prizeFund, ArrayList<Car> participants, int goldTime) {
        super(raceLength, raceRoute, prizeFund, participants);
        this.goldTime = goldTime;
    }

    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public String toString() {
        return "длина трассы = " + getRaceLength() + " км" +
                ", маршрут трассы = '" + getRaceRoute() + '\'' +
                ", призовой фонд = " + getPrizeFund() + " $" +
                ", участники: " + getParticipants() +
                ", лимит времени = " + goldTime + " с";
    }
}



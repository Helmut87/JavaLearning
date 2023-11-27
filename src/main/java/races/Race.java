package races;

import cars.Car;

import java.util.ArrayList;

public class Race {
    private int raceLength;
    private String raceRoute;
    private int prizeFund;
    private ArrayList<Car> participants;

    public Race() {
    }

    public Race(int raceLength, String raceRoute, int prizeFund, ArrayList<Car> participants) {
        this.raceLength = raceLength;
        this.raceRoute = raceRoute;
        this.prizeFund = prizeFund;
        this.participants = participants;
    }

    public int getRaceLength() {
        return raceLength;
    }

    public void setRaceLength(int raceLength) {
        this.raceLength = raceLength;
    }

    public String getRaceRoute() {
        return raceRoute;
    }

    public void setRaceRoute(String raceRoute) {
        this.raceRoute = raceRoute;
    }

    public int getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(int prizeFund) {
        this.prizeFund = prizeFund;
    }

    public ArrayList<Car> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Car> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return
                "длина трассы = " + raceLength + " км" +
                        ", маршрут трассы = '" + raceRoute + '\'' +
                        ", призовой фонд = " + prizeFund + " $" +
                        ", участники: " + participants;
    }
}

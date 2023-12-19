package races;

import cars.Car;

import java.util.ArrayList;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int raceLength, String raceRoute, int prizeFund, ArrayList<Car> participants, int laps) {
        super(raceLength, raceRoute, prizeFund, participants);
        this.laps = laps;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }
}

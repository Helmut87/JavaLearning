package races;

import cars.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int raceLength, String raceRoute, int prizeFund, ArrayList<Car> participants, int laps) {
        super(raceLength, raceRoute, prizeFund, participants);
        this.laps = laps;
    }
}

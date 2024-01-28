package races;

import cars.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int raceLength, String raceRoute, int prizeFund, ArrayList<Car> participants, int goldTime) {
        super(raceLength, raceRoute, prizeFund, participants);
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



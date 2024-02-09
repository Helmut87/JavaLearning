package races;

import cars.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Race {
    private int raceLength;
    private String raceRoute;
    private int prizeFund;
    private ArrayList<Car> participants;

    @Override
    public String toString() {
        return
                "длина трассы = " + raceLength + " км" +
                        ", маршрут трассы = '" + raceRoute + '\'' +
                        ", призовой фонд = " + prizeFund + " $" +
                        ", участники: " + participants;
    }
}

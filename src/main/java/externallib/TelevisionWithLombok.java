package externallib;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class TelevisionWithLombok {

    private String brand;
    private int yearOfProduction;
    private int screenSize;
    private Boolean isSmartTV;

    @Override
    public String toString() {
        return "Название телевизора: " + brand +
                ", собран в: " + yearOfProduction + " году" +
                ", разрешение экрана: " + screenSize + " пикселей" +
                ", присутствует ли smartTv: " + isSmartTV;
    }
}

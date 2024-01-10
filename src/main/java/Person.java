import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;
    private int age;

    public void setBirthDate(String birthDateStr) {
        this.birthDate = DateHelper.parseDate(birthDateStr);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " +
                new SimpleDateFormat("dd.MM.yyyy").format(birthDate) + " " +
                phoneNumber + " " + gender + " " + age;
    }
}

import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;
    private int age;

    public Person(String lastName, String firstName, String middleName, String birthDateStr, long phoneNumber, char gender, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        try {
            this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(birthDateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " +
                new SimpleDateFormat("dd.MM.yyyy").format(birthDate) + " " +
                phoneNumber + " " + gender + " " + age;
    }
}

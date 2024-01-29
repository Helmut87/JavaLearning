package exceptions;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(String id) {
        super("Авто с идентификатором " + id + " не найден.");
    }
}

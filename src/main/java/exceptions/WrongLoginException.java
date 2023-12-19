package exceptions;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Неверный формат логина!");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
package exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Неверный формат пароля!");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
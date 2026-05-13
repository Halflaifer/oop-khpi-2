package ua.khpi.oop.lab10.exception;

/**
 * Спеціалізований виняток для помилок у роботі контейнера.
 */
public class DocumentContainerException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DocumentContainerException(String message) {
        super(message);
    }

    public DocumentContainerException(String message, Throwable cause) {
        super(message, cause);
    }
}
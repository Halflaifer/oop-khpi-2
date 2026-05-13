package ua.khpi.oop.lab08.exception;


public class InvalidDocumentDataException extends Exception {
    private static final long serialVersionUID = 1L; 

    public InvalidDocumentDataException(String message) {
        super(message);
    }

    public InvalidDocumentDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
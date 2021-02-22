package edu.ntnu.tobiasth.idatt2001.hospital;

/**
 * A {@link RemoveException} is thrown when an object cannot be removed.
 */
public class RemoveException extends Exception {
    public RemoveException() {}
    public RemoveException(String message) {
        super(message);
    }
}

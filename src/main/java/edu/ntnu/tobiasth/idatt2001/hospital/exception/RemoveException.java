package edu.ntnu.tobiasth.idatt2001.hospital.exception;

/**
 * Thrown to indicate that an object could not be removed.
 *
 * @author trthingnes
 */
public class RemoveException extends Exception {
  /**
   * Constructs a {@link RemoveException}.
   *
   * @author trthingnes
   */
  public RemoveException() {}

  /**
   * Constructs a {@link RemoveException} with the specified message.
   *
   * @param message Message
   * @author trthingnes
   */
  public RemoveException(String message) {
    super(message);
  }
}

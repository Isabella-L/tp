package seedu.typists.common.exception;

public class FaultyInputException extends Exception {
    public FaultyInputException(String errorMessage) {
        super(errorMessage);
    }
}

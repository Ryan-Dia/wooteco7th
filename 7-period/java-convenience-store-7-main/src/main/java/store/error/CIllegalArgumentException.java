package store.error;

public class CIllegalArgumentException extends IllegalArgumentException {
    public CIllegalArgumentException(final ErrorMessages errorMessage) {
        super(errorMessage.getMessage());
    }
}

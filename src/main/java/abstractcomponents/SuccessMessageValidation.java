package abstractcomponents;

/**
 * Interface Strategy for Validating success message for Second Test Case
 */
public interface SuccessMessageValidation {
    void validateSuccessMessage(String fName, String email, String message) throws InterruptedException;
}

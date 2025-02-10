package day_01.ex02;

// UserNotFoundException is an unchecked exception thrown when a user with a specific ID is not found.
class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

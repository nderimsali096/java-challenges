package finki.advanced.lab02.challenge01;

public class InsufficientElementsException extends Exception{

    public InsufficientElementsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

class InvalidRowNumberException extends Exception {

    public InvalidRowNumberException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

class InvalidColumnNumberException extends Exception {

    public InvalidColumnNumberException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

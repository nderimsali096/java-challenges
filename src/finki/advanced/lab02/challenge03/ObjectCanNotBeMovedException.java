package finki.advanced.lab02.challenge03;

public class ObjectCanNotBeMovedException extends Exception {

    public ObjectCanNotBeMovedException(int pointX, int y) {
        super(String.format("Point (%d,%d) is out of bounds", pointX, y));

    }
}

class MovableObjectNotFittableException extends Exception {

    public MovableObjectNotFittableException(int x, int y, int radius) {
        super(String.format("Movable circle with center (%d,%d) and radius %d can not be fitted into the collection", x, y, radius));
    }
}

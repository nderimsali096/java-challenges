package finki.advanced.lab02.challenge03;

public class MovingCircle implements Movable{
    private final int radius;
    private MovingPoint center;

    public MovingCircle(int radius, MovingPoint center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public int getCurrentXPosition() {
        return 0;
    }

    @Override
    public int getCurrentYPosition() {
        return 0;
    }

    @Override
    public String getTypeInstance() {
        return null;
    }

    @Override
    public Movable moveInDirection(String direction) throws ObjectCanNotBeMovedException {
        return null;
    }

    @Override
    public int getRadius() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Movable circle with center coordinates (%d,%d) and radius %d",this.center.getX(),this.center.getY(),this.radius);
    }
}

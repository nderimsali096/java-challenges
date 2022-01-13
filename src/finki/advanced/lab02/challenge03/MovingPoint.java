package finki.advanced.lab02.challenge03;

public class MovingPoint implements Movable{
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovingPoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        if (this.y + this.ySpeed > MovablesCollection.xMAX)
            throw new ObjectCanNotBeMovedException(this.x, this.y + this.ySpeed);
        this.y = this.y + this.ySpeed;
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        if (this.y - this.ySpeed < 0)
            throw new ObjectCanNotBeMovedException(this.x, this.y + this.ySpeed);
        this.y = this.y - this.ySpeed;
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        if (this.x + this.xSpeed > MovablesCollection.xMAX)
            throw new ObjectCanNotBeMovedException(this.x, this.y + this.xSpeed);
        this.x = this.x + this.xSpeed;
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        if (this.x + this.xSpeed < 0)
            throw new ObjectCanNotBeMovedException(this.x, this.y + this.xSpeed);
        this.x = this.x + this.xSpeed;
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
        return String.format("Movable point with coordinates (%d,%d)",this.x,this.y);
    }
}

package finki.advanced.lab02.challenge03;

public interface Movable {

    void moveUp() throws ObjectCanNotBeMovedException;
    void moveDown() throws ObjectCanNotBeMovedException;
    void moveRight() throws ObjectCanNotBeMovedException;
    void moveLeft() throws ObjectCanNotBeMovedException;
    int getCurrentXPosition();
    int getCurrentYPosition();
    String getTypeInstance();
    Movable moveInDirection(String direction) throws ObjectCanNotBeMovedException;
    int getRadius();
}

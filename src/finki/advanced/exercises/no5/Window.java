package finki.advanced.exercises.no5;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Window implements Comparable<Window> {
    private String id;
    private List<Circle> circles;
    private List<Square> squares;

    public Window(String id, List<Circle> circles, List<Square> squares) {
        this.id = id;
        this.circles = new ArrayList<>();
        this.squares = new ArrayList<>();
        this.circles.addAll(circles);
        this.squares.addAll(squares);
    }

    public double getAreaOfCircles() {
        return this.circles.stream().mapToDouble(Circle::getArea).sum();
    }

    public double getAreaOfSquares() {
        return this.squares.stream().mapToDouble(Square::getArea).sum();
    }

    public double getAreaOfWindow() {
        return this.getAreaOfCircles() + this.getAreaOfSquares();
    }

    public double getMinArea() {
        return Math.min(this.getMinAreaCircle(), this.getMinAreaSquare());
    }

    public double getMaxArea() {
        return Math.max(this.getMaxAreaCircle(), this.getMaxAreaSquare());
    }

    public double getMinAreaCircle() {
        if (this.circles.size() == 0) return Double.MAX_VALUE;
        double minAreaCircle = this.circles.get(0).getArea();
        for (int i = 1;i < this.circles.size();i++) {
            if (this.circles.get(i).getArea() < minAreaCircle) {
                minAreaCircle = this.circles.get(i).getArea();
            }
        }
        return minAreaCircle;
    }

    public double getMinAreaSquare() {
        if (this.squares.size() == 0) return Double.MAX_VALUE;
        double minAreaSquare = this.squares.get(0).getArea();
        for (int i = 1;i < this.squares.size();i++) {
            if (this.squares.get(i).getArea() < minAreaSquare) {
                minAreaSquare = this.squares.get(i).getArea();
            }
        }
        return minAreaSquare;
    }

    public double getMaxAreaCircle() {
        if (this.circles.size() == 0) return Double.MIN_VALUE;
        double maxAreaCircle = this.circles.get(0).getArea();
        for (int i = 1;i < this.circles.size();i++) {
            if (this.circles.get(i).getArea() > maxAreaCircle) {
                maxAreaCircle = this.circles.get(i).getArea();
            }
        }
        return maxAreaCircle;
    }

    public double getMaxAreaSquare() {
        if (this.squares.size() == 0) return Double.MIN_VALUE;
        double maxAreaSquare = this.squares.get(0).getArea();
        for (int i = 1;i < this.squares.size();i++) {
            if (this.squares.get(i).getArea() > maxAreaSquare) {
                maxAreaSquare = this.squares.get(i).getArea();
            }
        }
        return maxAreaSquare;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %.2f %.2f %.2f",
                this.id,
                this.squares.size() + this.circles.size(),
                this.circles.size(),
                this.squares.size(),
                this.getMinArea(),
                this.getMaxArea(),
                this.getAreaOfWindow() / (this.squares.size() + this.circles.size()));
    }

    @Override
    public int compareTo(Window o) {
        if (this.getAreaOfWindow() > o.getAreaOfWindow()) return -1;
        else if(this.getAreaOfWindow() == o.getAreaOfWindow()) return 0;
        return 1;
    }
}

class Circle {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * (this.radius * this.radius);
    }
}

class Square {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public double getArea() {
        return this.side * this.side;
    }
}
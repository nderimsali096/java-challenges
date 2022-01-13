package finki.advanced.exercises.no5;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShapesApplication {
    private double maxArea;
    private List<Window> windows;

    public ShapesApplication(double maxArea) {
        this.maxArea = maxArea;
        this.windows = new ArrayList<>();
    }

    public void readCanvases(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            String canvas_id = parts[0];
            List<Circle> circles = new ArrayList<>();
            List<Square> squares = new ArrayList<>();
            try {
                for (int i = 1;i < parts.length;i += 2) {
                    if (parts[i].compareTo("C") == 0) {
                        Circle circle = new Circle(Integer.parseInt(parts[i + 1]));
                        if (circle.getArea() > maxArea) {
                            String message = String.format("Canvas %s has a shape with area larger than %.2f",canvas_id, this.maxArea);
                            throw new IrregularCanvasException(message);
                        }
                        circles.add(circle);
                    } else {
                        Square square = new Square(Integer.parseInt(parts[i + 1]));
                        if (square.getArea() > maxArea) {
                            String message = String.format("Canvas %s has a shape with area larger than %.2f",canvas_id, this.maxArea);
                            throw new IrregularCanvasException(message);
                        }
                        squares.add(square);
                    }
                }
                this.windows.add(new Window(canvas_id, circles, squares));
            } catch (IrregularCanvasException exception) {
                System.out.println(exception.getMessage());
            }
        }
        scanner.close();
    }

    public void printCanvases(OutputStream os) {
        PrintWriter printWriter = new PrintWriter(os);
        Collections.sort(this.windows);
        for (Window window : windows) printWriter.println(window);
        printWriter.close();
    }
}

class IrregularCanvasException extends Exception {

    public IrregularCanvasException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

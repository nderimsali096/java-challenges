package finki.advanced.exercises.no2;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShapesApplication {

    List<Window> windows;

    public ShapesApplication() {
        this.windows = new ArrayList<>();
    }

    public int readCanvases (InputStream inputStream) {
        int numberOfSquares = 0;
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            String canvas_id = parts[0];
            List<Integer> sizes = new ArrayList<>();
            for (int i = 1;i < parts.length;i++) {
                sizes.add(Integer.parseInt(parts[i]));
                numberOfSquares++;
            }
            this.windows.add(new Window(canvas_id, sizes));
        }
        return numberOfSquares;
    }

    public void printLargestCanvasTo (OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        Window window = Collections.max(this.windows);
        printWriter.println(window);
        printWriter.close();
    }
}

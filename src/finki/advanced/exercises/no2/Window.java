package finki.advanced.exercises.no2;

import java.util.ArrayList;
import java.util.List;

public class Window implements Comparable<Window> {
    private String canvasId;
    private List<Integer> sizes;


    public Window(String canvasId, List<Integer> sizes) {
        this.canvasId = canvasId;
        this.sizes = new ArrayList<>();
        this.sizes.addAll(sizes);
    }

    public int getNumberOfSizes() {
        return this.sizes.size();
    }

    public int getPerimeter() {
        return this.sizes.stream().mapToInt(size -> size).sum() * 4;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",this.canvasId, this.getNumberOfSizes(), this.getPerimeter());
    }

    @Override
    public int compareTo(Window o) {
        if (this.getPerimeter() > o.getPerimeter()) return 1;
        else if(this.getPerimeter() < o.getPerimeter()) return -1;
        return 0;
    }
}

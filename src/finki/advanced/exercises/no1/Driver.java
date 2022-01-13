package finki.advanced.exercises.no1;


public class Driver implements Comparable<Driver> {
    private final String name;
    private final String[] laps;

    public Driver(String name, String[] laps) {
        this.name = name;
        this.laps = new String[laps.length];
        System.arraycopy(laps, 0, this.laps, 0, laps.length);
    }

    public String getBestLap() {
        String best = laps[0];
        for(int i = 1;i < this.laps.length;i++) {
            String[] bestParts = best.split(":");
            String[] currentParts = this.laps[i].split(":");
            if (Integer.parseInt(bestParts[0]) > Integer.parseInt(currentParts[0])) {
                best = this.laps[i];
            } else if(Integer.parseInt(bestParts[0]) == Integer.parseInt(currentParts[0])) {
                if (Integer.parseInt(bestParts[1]) > Integer.parseInt(currentParts[1])) {
                    best = this.laps[i];
                } else if (Integer.parseInt(bestParts[1]) == Integer.parseInt(currentParts[1])) {
                    if (Integer.parseInt(bestParts[2]) > Integer.parseInt(currentParts[2])) {
                        best = this.laps[i];
                    }
                }
            }
        }
        return best;
    }

    public static Driver createDriver (String line) {
        String[] parts = line.split("\\s+");
        String name = parts[0];
        String[] laps = new String[3];
        System.arraycopy(parts, 1, laps, 0, parts.length - 1);
        return new Driver(name, laps);
    }


    @Override
    public String toString() {
        return String.format("%-10s%10s",this.name, getBestLap());
    }

    @Override
    public int compareTo(Driver o) {
        return this.getBestLap().compareTo(o.getBestLap());
    }
}

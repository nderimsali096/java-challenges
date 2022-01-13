package finki.advanced.exercises.no7;

import java.util.*;
import java.util.stream.IntStream;

public class Temperature implements Comparable<Temperature> {
    private int day;
    private List<String> temperatures;
    private List<Double> celsiusTemperatures;
    private List<Double> fahrenheitTemperatures;

    public Temperature(int day, List<String> temperatures) {
        this.day = day;
        this.temperatures = new ArrayList<>();
        this.temperatures.addAll(temperatures);
        this.setTemperatures();
    }

    public static Temperature createTemperature(String line) {
        String[] parts = line.split("\\s+");
        int dayOfYear = Integer.parseInt(parts[0]);
        List<String> listTemps = new ArrayList<>(Arrays.asList(parts).subList(1, parts.length));
        return new Temperature(dayOfYear,listTemps);
    }

    public void setTemperatures() {
        this.celsiusTemperatures = new ArrayList<>();
        this.fahrenheitTemperatures = new ArrayList<>();
        if (this.temperatures.get(0).contains("C")){
            IntStream
                    .range(0, this.temperatures.size())
                    .forEach(i -> this.celsiusTemperatures
                            .add(Double.parseDouble(this.temperatures.get(i).split("C")[0])));
            IntStream
                    .range(0, this.temperatures.size())
                    .forEach(i -> this.fahrenheitTemperatures
                            .add(this.getFahrenheit(Double.parseDouble(this.temperatures.get(i).split("C")[0]))));
        } else {
            IntStream
                    .range(0, this.temperatures.size())
                    .forEach(i -> this.fahrenheitTemperatures
                            .add(Double.parseDouble(this.temperatures.get(i).split("F")[0])));
            IntStream
                    .range(0, this.temperatures.size())
                    .forEach(i -> this.celsiusTemperatures
                            .add(this.getCelsius(Double.parseDouble(this.temperatures.get(i).split("F")[0]))));
        }
    }

    public double getFahrenheit(Double value) {
        return ((value * 9) / 5) + 32;
    }

    public double getCelsius(Double value) {
        return ((value - 32) * 5) / 9;
    }

    public DoubleSummaryStatistics getStatistics(char scale) {
        if (scale == 'C') return this.celsiusTemperatures.stream().mapToDouble((t) -> t).summaryStatistics();
        return this.fahrenheitTemperatures.stream().mapToDouble((t) -> t).summaryStatistics();
    }

    public String print(char scale) {
        DoubleSummaryStatistics statistics = this.getStatistics(scale);
        return String.format("%3d: Count:%4d Min:  %7.2f%c Max:  %7.2f%c Avg:  %7.2f%c "
                ,this.day
                ,statistics.getCount()
                ,statistics.getMin(),scale
                ,statistics.getMax(),scale
                ,statistics.getAverage(),scale);
    }

    @Override
    public int compareTo(Temperature o) {
        if (this.day > o.day) return 1;
        else if(this.day < o.day) return -1;
        return 0;
    }
}

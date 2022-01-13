package finki.advanced.exercises.no3;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherStation {

    private int days;
    private int totalMeasurements;
    private List<Measurement> measurements;

    public WeatherStation(int days) {
        this.days = days;
        this.totalMeasurements = 0;
        this.measurements = new ArrayList<>();
    }

    public void addMeasurment(float temperature, float wind, float humidity, float visibility, Date date) {
        if (checkIfDateIsValid(date)) {
            this.measurements.add(new Measurement(temperature, wind, humidity, visibility, date));
            totalMeasurements++;
            removeOldMeasurements(date);
        }
    }


    public void status(Date from, Date to) {
        List<Measurement> measurementsNeeded = this.getRequiredMeasurements(from, to);
        if (measurementsNeeded.size() == 0) throw new RuntimeException();
        for (Measurement measurement : measurementsNeeded) {
            System.out.println(measurement);
        }
        // measurementsNeeded.forEach(System.out::println);
        System.out.printf("Average temperature: %.2f", this.getAverageTemperature(measurementsNeeded));
    }

    public float getAverageTemperature(List<Measurement> measurementsNeeded) {
        float totalTemps = 0;
        for (Measurement measurement : measurementsNeeded) {
            totalTemps += measurement.getTemperature();
        }
        return totalTemps / measurementsNeeded.size();
    }

    public int total() {
        return this.totalMeasurements;
    }

    public void removeOldMeasurements(Date date) {

        for (int i = 0;i < this.measurements.size();i++) {
            long difference = date.getTime() - this.measurements.get(i).getDate().getTime();
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            if (differenceDates > this.days) {
                this.measurements.remove(this.measurements.get(i));
                this.totalMeasurements--;
            }
        }
    }

    public boolean checkIfDateIsValid(Date date) {
        for (Measurement measurement : this.measurements) {
            if ((double)Math.abs(getDifferenceOfDates(date, measurement.getDate())) < 2.5) {
                return false;
            }
        }
        return true;
    }

    public long getDifferenceOfDates(Date date1, Date date2) {
        long difference = date2.getTime() - date1.getTime();
        return (difference / (60 * 1000));
    }

    public List<Measurement> getRequiredMeasurements(Date from, Date to) {
        List<Measurement> resultList = new ArrayList<>();
        for (Measurement measurement : this.measurements) {
            if (measurement.getDate().compareTo(from) >= 0 && measurement.getDate().compareTo(to) <= 0) {
                resultList.add(measurement);
            }
        }
        return resultList;
        // return this.measurements.stream().filter(measurement -> measurement.getDate().compareTo(from) >= 0 && measurement.getDate().compareTo(to) <= 0).collect(Collectors.toList());
    }

    public static void main(String[] args) throws ParseException {
        WeatherStation weatherStation = new WeatherStation(5);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date1 = dateFormat.parse("10.12.2013 21:35:15");
        Date date2 = dateFormat.parse("10.12.2013 21:30:15");
        System.out.println(weatherStation.getDifferenceOfDates(date1, date2));
        long difference = date2.getTime() - date1.getTime();
        long difference_In_Minutes
                = (difference
                / (1000 * 60));
        System.out.println(difference_In_Minutes);
    }
}

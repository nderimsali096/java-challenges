package finki.advanced.exercises.no3;

import java.util.Date;

public class Measurement {
    private float temperature;
    private float wind;
    private float humidity;
    private float visibility;
    private Date date;


    public Measurement(float temperature, float wind, float humidity, float visibility, Date date) {
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.visibility = visibility;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return this.temperature + " " +
                this.wind + " km/h " +
                this.humidity + "% " +
                this.visibility + " km " +
                this.date.toString();
    }
}

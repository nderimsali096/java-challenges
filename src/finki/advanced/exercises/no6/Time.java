package finki.advanced.exercises.no6;

import java.util.Arrays;

public class Time implements Comparable<Time> {
    private String time;
    private int hour;
    private int minutes;


    public Time(String time) {
        this.time = time;
        this.hour = Integer.parseInt(time.split(":")[0]);
        this.minutes = Integer.parseInt(time.split(":")[1]);
    }

    public String print(TimeFormat format) {
        if (format == TimeFormat.FORMAT_24) {
            return String.format("%2s",this.time);
        }
        return String.format("%2s",this.fixAmPmTime());
    }

    public String fixAmPmTime() {
        if (this.hour == 0) {
            int fixedHour = this.hour + 12;
            return fixedHour + ":" + this.minutes + " AM";
        } else if (this.hour > 12) {
            int fixedHour = this.hour - 12;
            return fixedHour + ":" + this.minutes + " PM";
        }
        return this.time + " AM";
    }


    @Override
    public int compareTo(Time o) {
        if (this.hour == o.hour)
            return Integer.compare(minutes,o.minutes);
        return Integer.compare(hour,o.hour);
    }
}

class UnsupportedFormatException extends Exception {

    public UnsupportedFormatException(String time) {
        super(time);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

class InvalidTimeException extends Exception {

    public InvalidTimeException(String time) {
        super(time);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
package finki.advanced.exercises.no6;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TimeTable {

    private List<Time> timeList;

    public TimeTable() {
        this.timeList = new ArrayList<>();
    }

    public void readTimes(InputStream inputStream) throws  UnsupportedFormatException, InvalidTimeException {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            for (String part : parts) {
                if (part.contains(":") || part.contains(".")) {
                    String time = part.replace(".", ":");
                    if (this.checkTimeValidation(time, ":")) throw new InvalidTimeException(part);
                    else this.timeList.add(new Time(time));
                } else throw new UnsupportedFormatException(part);
            }
        }
        scanner.close();
    }

    public void writeTimes(OutputStream outputStream, TimeFormat format) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        Collections.sort(this.timeList);
        if (format == TimeFormat.FORMAT_AMPM) {
            for (Time time : this.timeList) {
                printWriter.println(time.print(TimeFormat.FORMAT_AMPM));
            }
        }
        if (format == TimeFormat.FORMAT_24) {
            for (Time time : this.timeList) {
                printWriter.println(time.print(TimeFormat.FORMAT_24));
            }
        }
        printWriter.close();
    }

    public boolean checkTimeValidation(String time, String regex) {
        int hours = Integer.parseInt(time.split(regex)[0]);
        int minutes = Integer.parseInt(time.split(regex)[1]);
        return hours < 0 || hours > 23 || minutes < 0 || minutes > 59;
    }
}

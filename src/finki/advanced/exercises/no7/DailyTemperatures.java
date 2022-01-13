package finki.advanced.exercises.no7;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DailyTemperatures {
    private List<Temperature> dailyTemperatures;


    public DailyTemperatures() {
        this.dailyTemperatures = new ArrayList<>();
    }

    public void readTemperatures(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        this.dailyTemperatures = bufferedReader.lines().map(Temperature::createTemperature).collect(Collectors.toList());
    }

    public void writeDailyStats(OutputStream outputStream, char scale) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        this.dailyTemperatures.sort(Temperature::compareTo);
        this.dailyTemperatures.forEach(temperature -> printWriter.println(temperature.print(scale)));
        printWriter.flush();
    }
}

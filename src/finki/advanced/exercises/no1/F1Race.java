package finki.advanced.exercises.no1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class F1Race {
    List<Driver> drivers;

    public F1Race() {
        this.drivers = new ArrayList<>();
    }

    public void readResults(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        this.drivers = bufferedReader.lines().map(Driver::createDriver).collect(Collectors.toList());
//        Scanner scanner = new Scanner(inputStream);
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            String[] parts = line.split("\\s+");
//            String driverName = parts[0];
//            String[] laps = new String[3];
//            int j = 0;
//            for (int i = 1;i < parts.length;i++) {
//                laps[j++] = parts[i];
//            }
//            this.drivers.add(new Driver(driverName, laps));
//        }
//        scanner.close();
    }

    public void printSorted(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        this.drivers.sort((driver, o) -> driver.compareTo(o));
        int index = 1;
        for (Driver driver : this.drivers) {
            printWriter.printf("%d. %s",index++, driver);
            printWriter.println();
        }
        printWriter.close();
    }
}

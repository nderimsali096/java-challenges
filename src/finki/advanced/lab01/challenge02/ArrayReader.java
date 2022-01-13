package finki.advanced.lab01.challenge02;

import java.io.InputStream;
import java.util.Scanner;

public class ArrayReader {

    public static IntegerArray readIntegerArray(InputStream input) {
        Scanner scanner = new Scanner(input);
        int length = scanner.nextInt();
        int[] readArray = new int[length];
        for (int i = 0;i < length;i++) {
            readArray[i] = scanner.nextInt();
        }
        return new IntegerArray(readArray);
    }
}

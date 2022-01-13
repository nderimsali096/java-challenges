package finki.advanced.lab02.challenge01;

import java.io.InputStream;
import java.util.Scanner;

public class MatrixReader {

    public static DoubleMatrix read(InputStream input) throws InsufficientElementsException {
        Scanner scanner = new Scanner(input);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[] matrixElements = new double[rows * columns];
        int index = 0;
        while (scanner.hasNextDouble()) {
            matrixElements[index++] = scanner.nextDouble();
        }
        scanner.close();
        return new DoubleMatrix(matrixElements, rows, columns);
    }
}

package finki.advanced.lab02.challenge01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public final class DoubleMatrix {
    private final int rows;
    private final int columns;
    private final double[][] matrixOfDoubles;

    public DoubleMatrix(double[] a, int m, int n) throws InsufficientElementsException {
        if (a.length < m * n) throw new InsufficientElementsException("Insufficient number of elements");
        this.rows = m;
        this.columns = n;
        this.matrixOfDoubles = new double[m][n];
        int counter = 0;
        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                matrixOfDoubles[i][j] = a[a.length - 1 - counter];
                counter++;
            }
        }
    }

    public String getDimensions() {
        return String.format("[%d x %d]", rows, columns);
    }

    public int rows() {
        return rows;
    }

    public int columns() {
        return columns;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException {
        row = row - 1;
        if (row < 0 || row >= this.rows) throw new InvalidRowNumberException("Invalid row number");
        double maxElement = this.matrixOfDoubles[row][0];
        for (int i = 1;i < this.columns;i++) {
            if (this.matrixOfDoubles[row][i] > maxElement) {
                maxElement = this.matrixOfDoubles[row][i];
            }
        }
        return maxElement;
    }

    public double maxElementAtColumn(int column) throws InvalidColumnNumberException {
        column = column - 1;
        if (column < 0 || column >= this.columns) throw new InvalidColumnNumberException("Invalid column number");
        double maxElement = this.matrixOfDoubles[0][column];
        for (int i = 1;i < this.rows;i++) {
            if (this.matrixOfDoubles[i][column] > maxElement) {
                maxElement = this.matrixOfDoubles[i][column];
            }
        }
        return maxElement;
    }

    public double sum() {
        double sum = 0;
        for (int i = 0;i < this.rows;i++) {
            for (int j = 0;j < this.columns;j++) {
                sum += this.matrixOfDoubles[i][j];
            }
        }
        return sum;
    }

    public double[] toSortedArray() {
        double[] result = new double[this.rows * this.columns];
        int index = 0;
        for (int i = 0;i < this.rows;i++) {
            for (int j = 0;j < this.columns;j++) {
                result[index++] = this.matrixOfDoubles[i][j];
            }
        }
//        Double [] arr = new Double[result.length];
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = result[i];
//        }
//        Arrays.sort(arr, Collections.reverseOrder());
//        for(int i = 0;i < arr.length;i++){
//            result[i] = arr[i];
//        }
        bubbleSort(result);
        return result;
    }

    public void bubbleSort(double[] sampleArray) {
        for (int i = 0;i < sampleArray.length;i++) {
            for (int j = 0;j < i;j++) {
                if (sampleArray[i] > sampleArray[j]) {
                    double temporary = sampleArray[i];
                    sampleArray[i] = sampleArray[j];
                    sampleArray[j] = temporary;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < this.rows;i++) {
            for (int j = 0;j < this.columns;j++) {
                String element = String.format("%.2f",this.matrixOfDoubles[i][j]);
                stringBuilder.append(element);
                if (j < this.columns - 1) {
                    stringBuilder.append("\t");
                }
            }
            if (i < this.rows - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return rows == that.rows && columns == that.columns && Arrays.deepEquals(matrixOfDoubles, that.matrixOfDoubles);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.deepHashCode(matrixOfDoubles);
        return result;
    }
}

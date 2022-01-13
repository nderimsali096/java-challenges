package finki.advanced.lab01.challenge02;

import java.util.Arrays;

public final class IntegerArray {


    private final int[] arrayOfIntegers;

    public IntegerArray(int a[]) {
        arrayOfIntegers = new int[a.length];
        System.arraycopy(a, 0, arrayOfIntegers, 0, a.length);
    }

    public int length() {
        return this.arrayOfIntegers.length;
    }

    public int getElementAt(int i) {
        return this.arrayOfIntegers[i];
    }

    public int sum(){
        int result = 0;
        for (int element : this.arrayOfIntegers) result += element;
        return result;
    }

    public double average() {
        return (double)this.sum() / this.length();
    }

    public IntegerArray getSorted() {
        int[] sortedArr = new int[this.length()];
        System.arraycopy(this.arrayOfIntegers, 0, sortedArr, 0, this.length());
        Arrays.sort(sortedArr);
        return new IntegerArray(sortedArr);
    }

    public IntegerArray concat(IntegerArray ia) {
        int [] finalArr = new int[this.length() + ia.length()];
        int index = 0;
        for (int i = 0;i < this.length();i++) {
            finalArr[index++] = this.arrayOfIntegers[i];
        }
        for (int i = 0;i < ia.length();i++) {
            finalArr[index++] = ia.arrayOfIntegers[i];
        }
        return new IntegerArray(finalArr);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0;i < this.length();i++) {
            if (i == this.length() - 1) {
                stringBuilder.append(this.arrayOfIntegers[i]);
            } else {
                stringBuilder.append(this.arrayOfIntegers[i]);
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(arrayOfIntegers, that.arrayOfIntegers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayOfIntegers);
    }
}

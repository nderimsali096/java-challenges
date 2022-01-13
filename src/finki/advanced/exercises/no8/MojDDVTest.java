package finki.advanced.exercises.no8;

public class MojDDVTest {
    public static void main(String[] args) {
        MojDDV mojDDV = new MojDDV();

        System.out.println("===READING RECORDS FROM INPUT STREAM===");
        mojDDV.readRecords(System.in);

        System.out.println("===PRINTING TAX RETURNS RECORDS TO OUTPUT STREAM ===");
        mojDDV.printTaxReturns(System.out);
        mojDDV.printStatistics(System.out);
    }
}

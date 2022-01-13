package finki.advanced.exercises.no8;

import java.io.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MojDDV {

    private List<DDV> ddvList;

    public MojDDV() {
        this.ddvList = new ArrayList<>();
    }

    public void readRecords (InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        this.ddvList = bufferedReader.lines().map(line -> {
            try {
                return DDV.createDdv(line);
            } catch (AmountNotAllowedException e) {
                System.out.println(e.getMessage());;
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public void printTaxReturns (OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        this.ddvList.forEach(printWriter::println);
        printWriter.flush();
    }


    public DoubleSummaryStatistics getStatistics() {
        return this.ddvList.stream().mapToDouble(DDV::getTaxReturn).summaryStatistics();
    }

    public void printStatistics(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        DoubleSummaryStatistics statistics = this.getStatistics();
        String result = String.format("min:\t%5.3f\n" +
                "max:\t%5.3f\n" +
                "sum:\t%5.3f\n" +
                "count:\t%-5d\n" +
                "avg:\t%5.3f",
                statistics.getMin(),
                statistics.getMax(),
                statistics.getSum(),
                statistics.getCount(),
                statistics.getAverage()
        );
        printWriter.print(result);
        printWriter.flush();
    }
}

class DDV {
    private int id;
    private List<Item> items;

    public DDV(int id, List<Item> items) {
        this.id = id;
        this.items = new ArrayList<>();
        this.items.addAll(items);
    }

    public static DDV createDdv (String line) throws AmountNotAllowedException {
        String[] parts = line.split("\\s+");
        int ddvId = Integer.parseInt(parts[0]);
        List<Item> ddvItems = new ArrayList<>();
        for (int i = 1;i < parts.length;i += 2) {
            if (parts[i + 1].compareTo("B") == 0) {
                ddvItems.add(new Item(Integer.parseInt(parts[i]),"B"));
            } else if(parts[i + 1].compareTo("V") == 0) {
                ddvItems.add(new Item(Integer.parseInt(parts[i]),"V"));
            } else {
                ddvItems.add(new Item(Integer.parseInt(parts[i]),"A"));
            }
        }
        DDV ddv = new DDV(ddvId, ddvItems);
        int sum = ddv.getSum();
        if (sum > 30000) throw new AmountNotAllowedException(sum + "");
        else return ddv;
    }

    public int getSum() {
        return this.items.stream().mapToInt(Item::getPrice).sum();
    }

    public double getTaxReturn () {
        return this.items.stream().mapToDouble(Item::getTaxReturn).sum();
    }

    @Override
    public String toString() {
        return String.format("-%10d\t%10d\t%10.5f",this.id, this.getSum(), this.getTaxReturn());
    }
}


class Item {
    private int price;
    private String type;


    public Item(int price, String type) {
        this.price = price;
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public double getTaxReturn() {
        if (this.getType().compareTo("A") == 0) {
            return this.getPrice() * 0.18 * 0.15;
        } else if (this.getType().compareTo("B") == 0) {
            return this.getPrice() * 0.05 * 0.15;
        }
        return 0.0;
    }
}

class AmountNotAllowedException extends Exception {
    public AmountNotAllowedException(String amount) {
        super("Receipt with amount " + amount + " is not allowed to be scanned");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

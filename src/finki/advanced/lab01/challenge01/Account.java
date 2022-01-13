package finki.advanced.lab01.challenge01;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;

class Account {

    private final String name;
    private final long id;
    private String balance;

    public Account(String name, String balance) {
        this.name = name;
        this.balance = balance;
        Random random = new Random();
        this.id = random.nextLong();
    }

    public long getId() {
        return id;
    }

    public String getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
    public float getFloatBalance() {
        return Float.parseFloat(balance.substring(0,balance.length() - 1));
    }

    public void setBalance(String balance) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        this.balance = decimalFormat.format(Float.parseFloat(balance.substring(0, balance.length() - 1)));
        this.balance += "$";
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nBalance: %s\n",name, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.getId() && name.equals(account.getName()) && balance.equals(account.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, balance);
    }
}

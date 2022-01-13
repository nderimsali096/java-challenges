package finki.advanced.lab01.challenge01;

import java.util.Objects;

public abstract class Transaction {

    private long fromId;
    private long toId;
    private String description;
    private String amount;

    public Transaction(long fromId, long toId, String description, String amount) {
        this.fromId = fromId;
        this.toId = toId;
        this.description = description;
        this.amount = amount;
    }
    public long getFromId() {
        return fromId;
    }

    public long getToId() {
        return toId;
    }

    public String getAmount() {
        return amount;
    }

    public float getFloatAmount(){
        return Float.parseFloat(amount.substring(0,amount.length() - 1));
    }

    public String getDescription() {
        return description;
    }

    public abstract float getProvision();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return fromId == that.fromId && toId == that.toId && description.equals(that.description) && amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromId, toId, description, amount);
    }
}

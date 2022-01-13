package finki.advanced.lab01.challenge01;

import java.util.Objects;

public class FlatPercentProvisionTransaction extends Transaction {

    private final int flatPercent;

    public FlatPercentProvisionTransaction(long fromId, long toId, String amount, int centsPerDolar) {
        super(fromId, toId, "FlatPercent", amount);
        flatPercent = centsPerDolar;
    }

    public int getPercent() {
        return flatPercent;
    }

    @Override
    public float getFloatAmount(){
        return super.getFloatAmount() + getProvision();
    }

    @Override
    public float getProvision() {
        return (float) (flatPercent/100.0 * (int)super.getFloatAmount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return flatPercent == that.getPercent();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPercent());
    }
}

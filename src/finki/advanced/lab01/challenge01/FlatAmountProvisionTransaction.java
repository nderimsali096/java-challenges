package finki.advanced.lab01.challenge01;

import java.util.Objects;

public class FlatAmountProvisionTransaction extends Transaction {

    private final String flatAmount;


    public FlatAmountProvisionTransaction(long fromId, long toId, String amount, String flatProvision) {
        super(fromId, toId, "FlatAmount", amount);
        flatAmount = flatProvision;
    }

    public String getFlatAmount() {
        return flatAmount;
    }

    @Override
    public float getFloatAmount(){
        return super.getFloatAmount() + getProvision();
    }

    @Override
    public float getProvision() {
        return Float.parseFloat(flatAmount.substring(0,flatAmount.length() - 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;
        return flatAmount.equals(that.getFlatAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatAmount);
    }
}

package finki.advanced.lab01.challenge01;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;

public class Bank {

    private final String name;
    private final Account[] accounts;
    private float totalMoney;
    private float totalProvision;
    private Account fromAcc;
    private Account toAcc;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = new Account[accounts.length];

        System.arraycopy(accounts, 0, this.accounts, 0, accounts.length);

        this.totalMoney = 0;
        this.totalProvision = 0;
        this.fromAcc = null;
        this.toAcc = null;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public String totalTransfers() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(totalMoney) + "$";
    }

    public String totalProvision() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(totalProvision) + "$";
    }

    public boolean makeTransaction (Transaction t) {
        int toId = findId(t.getToId());
        int fromId = findId(t.getFromId());
        if (toId == -1 || fromId == -1) return false;
        float newBalanceForSender = accounts[fromId].getFloatBalance();
        float newBalanceForReceiver = accounts[toId].getFloatBalance();
        if (newBalanceForSender < t.getFloatAmount()) return false;
        totalMoney += t.getFloatAmount() - t.getProvision();
        totalProvision += t.getProvision();
        newBalanceForSender -= t.getFloatAmount();
        if (toId == fromId) newBalanceForReceiver -= t.getProvision();
        else newBalanceForReceiver += t.getFloatAmount() - t.getProvision();
        accounts[fromId].setBalance(newBalanceForSender + "$");
        accounts[toId].setBalance(newBalanceForReceiver+ "$");
        return true;
    }

    public boolean findIds (Transaction t) {
        int bothAreInBank = 0;
        for (Account account: accounts) {
            if (account.getId() == t.getFromId()) {
                fromAcc = account;
                bothAreInBank++;
            } else if (account.getId() == t.getToId()) {
                bothAreInBank++;
                toAcc = account;
            }
        }
        return bothAreInBank >= 2;
    }

    public int findId(long id) {
        for (int i = 0;i < accounts.length;i++) {
            if (accounts[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ");
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append("\n");
        for (Account account : accounts) {
            stringBuilder.append(account.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return  totalMoney == bank.totalMoney &&
                totalProvision == bank.totalProvision &&
                name.equals(bank.name) &&
                Arrays.equals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(accounts);
        return result;
    }
}

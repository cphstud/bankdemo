package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<Transaction> transactions;
    private Customer customer;
    private final int id ;

    public Account(int id, Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getBalance(){
        // TODO: skal debugges
        int sum = 0;
        for (Transaction t : transactions) {
            sum += t.getAmount();
        }
        return sum;
    }

    public int withDrawAmount(int amount) throws NotEnoughMoneyException {
        amount = Math.abs(amount);
        if (this.getBalance() - amount < 0) {
            throw new NotEnoughMoneyException("Not enough");
        } else {
            transactions.add(new Transaction(-amount, LocalDateTime.now()));
        }
        return getBalance();
    }

    public int depositAmount(int amount){
        // TODO: skal debugges og returnere ny saldo. Smid fejl hvis amount < 0.
        transactions.add(new Transaction(amount, LocalDateTime.now()));
        return 0;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public static Account.ID idFromInd(int id) {
        return new Account.ID(id);
    }

    public static class ID {
        private final int id;
        public ID(int feed) {
            this.id=feed;
        }
    }
}
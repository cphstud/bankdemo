package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {

    private final int amount;
    private int id;
    private final LocalDateTime date;

    public Transaction(int id, int amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
        this.id = id;
    }
    public Transaction(int amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
}

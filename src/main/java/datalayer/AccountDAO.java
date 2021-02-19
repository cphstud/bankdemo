package datalayer;

import domain.Account;
import domain.Customer;
import domain.Transaction;
import domain.NotEnoughMoneyException;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountDAO {
    public List<Account> getAllAccounts();
    public Account getAccountById(int id);
    public Account createAcc(int id,Customer c);
    public Transaction createTra(Account acc, int amount, LocalDateTime lt);
    public void delete(Account acc);
}


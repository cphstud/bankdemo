package entries;

import datalayer.Database;
import domain.Account;
import domain.Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
    Database db;
    List<Account> accountList;
    List<Customer> customerList;

    public Bank(Database db) {
        this.db = db;
    }

    public void insertMoney(int id) {
        Account acc = db.getAccountById(id);

    }
}

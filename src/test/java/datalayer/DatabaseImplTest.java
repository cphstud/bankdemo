package datalayer;

import domain.Account;
import domain.Customer;
import domain.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseImplTest {
    Database d;

    @BeforeEach
    void setUp() {
        d = new DatabaseImpl();
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    void getAccountById() {
    }

    @Test
    void createTrans() {
        Customer c =  d.getCustomerFromId(55);
        //Account acc = d.createAcc(1,c);
        Account acc = d.getAccountById(1);
        LocalDateTime lt = LocalDateTime.now();
        Transaction t = d.createTra(acc,100,lt);
        assertNotNull(acc);
    }


    @Test
    void createAcc() {
        Customer c =  d.getCustomerFromId(55);
        Account acc = d.createAcc(1,c);
        assertNotNull(acc);
    }

    @Test
    void depositMoneyTest() {
        Customer c =  d.getCustomerFromId(55);
        Account acc = d.getAccountById(1);
        acc.depositAmount(123);
        assertNotNull(acc);
    }

    @Test
    void delete() {
    }

    @Test
    void createCustomer() {
        Customer c = d.createCustomer("Verner",3);
        assertNotNull(c);
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void getCustomerFromId() {
    }

}
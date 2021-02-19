package datalayer;

import domain.Account;
import domain.Customer;

import java.util.List;

public interface Database extends AccountDAO, CustomerDAO {
    @Override
    List<Account> getAllAccounts();

    @Override
    Account getAccountById(int id);

    @Override
    void delete(Account acc);

    @Override
    Customer createCustomer(String name, int id);

    @Override
    List<Customer> getAllCustomers();

    @Override
    Customer getCustomerFromId(int id);
}
